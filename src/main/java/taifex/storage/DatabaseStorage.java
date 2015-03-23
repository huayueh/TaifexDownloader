package taifex.storage;

import org.apache.log4j.Logger;
import taifex.downloader.Downloader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * User: Harvey
 * Date: 2015/3/3
 * Time: 下午 06:22
 */
public class DatabaseStorage implements Storage {
    private static final Logger logger = Logger.getLogger(DatabaseStorage.class);
    private static final String UNIT_NAME = "jdbc:derby:Database;client";
    protected EntityManager em;

    public DatabaseStorage(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager eManager = emfactory.createEntityManager();
        em = eManager;
    }

    @Override
    public boolean save(InputStream is, Downloader downloader) {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is, "Big5"));
            line = br.readLine();

            if (line != null && !line.startsWith(downloader.getFirstLine())) {
                return true;
            }

            line = br.readLine();

            int count = 0;
            if (!em.getTransaction().isActive()){
                em.getTransaction().begin();
            }
            //start from second row
            while (line != null && line.length() > 0) {
                count++;
                logger.info(line);
                Object obj = downloader.rowToPojo(line);
                if (obj != null) {
                    em.persist(obj);
                }
                line = br.readLine();
            }
            em.getTransaction().commit();
            em.clear();
            logger.debug("Total record : " + count);
            return true;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            logger.error(downloader.getTableName(), ex);
            return false;
        }
    }

    @Override
    public Date getLastDate(Downloader downloader) {
        Date date = null;
        String table = downloader.getTableName();
        String strQuery = "SELECT DATE FROM " + table + " ORDER BY DATE DESC FETCH FIRST 1 ROWS ONLY";
        Query q = em.createNativeQuery(strQuery);

        try {
            date = (Date) q.getSingleResult();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return date;
    }
}
