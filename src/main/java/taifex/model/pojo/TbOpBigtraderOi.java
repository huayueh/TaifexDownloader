/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taifex.model.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author Harvey
 */
@Entity
@Table(name = "TB_OP_BIGTRADER_OI")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOpBigtraderOi.findAll", query = "SELECT t FROM TbOpBigtraderOi t"),
    @NamedQuery(name = "TbOpBigtraderOi.findByDate", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.tbOpBigtraderOiPK.date = :date"),
    @NamedQuery(name = "TbOpBigtraderOi.findByContract", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.tbOpBigtraderOiPK.contract = :contract"),
    @NamedQuery(name = "TbOpBigtraderOi.findByContractName", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.contractName = :contractName"),
    @NamedQuery(name = "TbOpBigtraderOi.findByPutCall", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.tbOpBigtraderOiPK.putCall = :putCall"),
    @NamedQuery(name = "TbOpBigtraderOi.findByContractMonth", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.tbOpBigtraderOiPK.contractMonth = :contractMonth"),
    @NamedQuery(name = "TbOpBigtraderOi.findByTraderType", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.tbOpBigtraderOiPK.traderType = :traderType"),
    @NamedQuery(name = "TbOpBigtraderOi.findByTop5BuyOi", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.top5BuyOi = :top5BuyOi"),
    @NamedQuery(name = "TbOpBigtraderOi.findByTop5SellOi", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.top5SellOi = :top5SellOi"),
    @NamedQuery(name = "TbOpBigtraderOi.findByTop10BuyOi", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.top10BuyOi = :top10BuyOi"),
    @NamedQuery(name = "TbOpBigtraderOi.findByTop10SellOi", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.top10SellOi = :top10SellOi"),
    @NamedQuery(name = "TbOpBigtraderOi.findByWholeMarket", query = "SELECT t FROM TbOpBigtraderOi t WHERE t.wholeMarket = :wholeMarket")})
public class TbOpBigtraderOi implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbOpBigtraderOiPK tbOpBigtraderOiPK;
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Column(name = "TOP5_BUY_OI")
    private Integer top5BuyOi;
    @Column(name = "TOP5_SELL_OI")
    private Integer top5SellOi;
    @Column(name = "TOP10_BUY_OI")
    private Integer top10BuyOi;
    @Column(name = "TOP10_SELL_OI")
    private Integer top10SellOi;
    @Column(name = "WHOLE_MARKET")
    private Integer wholeMarket;

    public TbOpBigtraderOi() {
    }

    public TbOpBigtraderOi(TbOpBigtraderOiPK tbOpBigtraderOiPK) {
        this.tbOpBigtraderOiPK = tbOpBigtraderOiPK;
    }

    public TbOpBigtraderOi(Date date, String contract, String putCall, String contractMonth, String traderType) {
        this.tbOpBigtraderOiPK = new TbOpBigtraderOiPK(date, contract, putCall, contractMonth, traderType);
    }

    public TbOpBigtraderOiPK getTbOpBigtraderOiPK() {
        return tbOpBigtraderOiPK;
    }

    public void setTbOpBigtraderOiPK(TbOpBigtraderOiPK tbOpBigtraderOiPK) {
        this.tbOpBigtraderOiPK = tbOpBigtraderOiPK;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Integer getTop5BuyOi() {
        return top5BuyOi;
    }

    public void setTop5BuyOi(Integer top5BuyOi) {
        this.top5BuyOi = top5BuyOi;
    }

    public Integer getTop5SellOi() {
        return top5SellOi;
    }

    public void setTop5SellOi(Integer top5SellOi) {
        this.top5SellOi = top5SellOi;
    }

    public Integer getTop10BuyOi() {
        return top10BuyOi;
    }

    public void setTop10BuyOi(Integer top10BuyOi) {
        this.top10BuyOi = top10BuyOi;
    }

    public Integer getTop10SellOi() {
        return top10SellOi;
    }

    public void setTop10SellOi(Integer top10SellOi) {
        this.top10SellOi = top10SellOi;
    }

    public Integer getWholeMarket() {
        return wholeMarket;
    }

    public void setWholeMarket(Integer wholeMarket) {
        this.wholeMarket = wholeMarket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbOpBigtraderOiPK != null ? tbOpBigtraderOiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOpBigtraderOi)) {
            return false;
        }
        TbOpBigtraderOi other = (TbOpBigtraderOi) object;
        if ((this.tbOpBigtraderOiPK == null && other.tbOpBigtraderOiPK != null) || (this.tbOpBigtraderOiPK != null && !this.tbOpBigtraderOiPK.equals(other.tbOpBigtraderOiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbOpBigtraderOi[ tbOpBigtraderOiPK=" + tbOpBigtraderOiPK + " ]";
    }
    
}
