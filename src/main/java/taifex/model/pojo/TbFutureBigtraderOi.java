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
@Table(name = "TB_FUTURE_BIGTRADER_OI")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFutureBigtraderOi.findAll", query = "SELECT t FROM TbFutureBigtraderOi t"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByDate", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.tbFutureBigtraderOiPK.date = :date"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByContract", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.tbFutureBigtraderOiPK.contract = :contract"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByContractName", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.contractName = :contractName"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByContractMonth", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.tbFutureBigtraderOiPK.contractMonth = :contractMonth"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByTraderType", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.tbFutureBigtraderOiPK.traderType = :traderType"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByTop5BuyOi", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.top5BuyOi = :top5BuyOi"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByTop5SellOi", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.top5SellOi = :top5SellOi"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByTop10BuyOi", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.top10BuyOi = :top10BuyOi"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByTop10SellOi", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.top10SellOi = :top10SellOi"),
    @NamedQuery(name = "TbFutureBigtraderOi.findByWholeMarket", query = "SELECT t FROM TbFutureBigtraderOi t WHERE t.wholeMarket = :wholeMarket")})
public class TbFutureBigtraderOi implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbFutureBigtraderOiPK tbFutureBigtraderOiPK;
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

    public TbFutureBigtraderOi() {
    }

    public TbFutureBigtraderOi(TbFutureBigtraderOiPK tbFutureBigtraderOiPK) {
        this.tbFutureBigtraderOiPK = tbFutureBigtraderOiPK;
    }

    public TbFutureBigtraderOi(Date date, String contract, int contractMonth, String traderType) {
        this.tbFutureBigtraderOiPK = new TbFutureBigtraderOiPK(date, contract, contractMonth, traderType);
    }

    public TbFutureBigtraderOiPK getTbFutureBigtraderOiPK() {
        return tbFutureBigtraderOiPK;
    }

    public void setTbFutureBigtraderOiPK(TbFutureBigtraderOiPK tbFutureBigtraderOiPK) {
        this.tbFutureBigtraderOiPK = tbFutureBigtraderOiPK;
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
        hash += (tbFutureBigtraderOiPK != null ? tbFutureBigtraderOiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFutureBigtraderOi)) {
            return false;
        }
        TbFutureBigtraderOi other = (TbFutureBigtraderOi) object;
        if ((this.tbFutureBigtraderOiPK == null && other.tbFutureBigtraderOiPK != null) || (this.tbFutureBigtraderOiPK != null && !this.tbFutureBigtraderOiPK.equals(other.tbFutureBigtraderOiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbFutureBigtraderOi[ tbFutureBigtraderOiPK=" + tbFutureBigtraderOiPK + " ]";
    }
    
}
