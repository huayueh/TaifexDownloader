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
@Table(name = "TB_OP_HIS")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOpHis.findAll", query = "SELECT t FROM TbOpHis t"),
    @NamedQuery(name = "TbOpHis.findByHighPrice", query = "SELECT t FROM TbOpHis t WHERE t.highPrice = :highPrice"),
    @NamedQuery(name = "TbOpHis.findByLowPrice", query = "SELECT t FROM TbOpHis t WHERE t.lowPrice = :lowPrice"),
    @NamedQuery(name = "TbOpHis.findByContract", query = "SELECT t FROM TbOpHis t WHERE t.tbOpHisPK.contract = :contract"),
    @NamedQuery(name = "TbOpHis.findByClosePrice", query = "SELECT t FROM TbOpHis t WHERE t.closePrice = :closePrice"),
    @NamedQuery(name = "TbOpHis.findByExcercisePrice", query = "SELECT t FROM TbOpHis t WHERE t.tbOpHisPK.excercisePrice = :excercisePrice"),
    @NamedQuery(name = "TbOpHis.findByVolumn", query = "SELECT t FROM TbOpHis t WHERE t.volumn = :volumn"),
    @NamedQuery(name = "TbOpHis.findByOpenPrice", query = "SELECT t FROM TbOpHis t WHERE t.openPrice = :openPrice"),
    @NamedQuery(name = "TbOpHis.findBySettlePrice", query = "SELECT t FROM TbOpHis t WHERE t.settlePrice = :settlePrice"),
    @NamedQuery(name = "TbOpHis.findByContractMonth", query = "SELECT t FROM TbOpHis t WHERE t.tbOpHisPK.contractMonth = :contractMonth"),
    @NamedQuery(name = "TbOpHis.findByOi", query = "SELECT t FROM TbOpHis t WHERE t.oi = :oi"),
    @NamedQuery(name = "TbOpHis.findByDate", query = "SELECT t FROM TbOpHis t WHERE t.tbOpHisPK.date = :date"),
    @NamedQuery(name = "TbOpHis.findByLastBuyPrice", query = "SELECT t FROM TbOpHis t WHERE t.lastBuyPrice = :lastBuyPrice"),
    @NamedQuery(name = "TbOpHis.findByOptionType", query = "SELECT t FROM TbOpHis t WHERE t.tbOpHisPK.optionType = :optionType"),
    @NamedQuery(name = "TbOpHis.findByLastSellPrice", query = "SELECT t FROM TbOpHis t WHERE t.lastSellPrice = :lastSellPrice")})
public class TbOpHis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbOpHisPK tbOpHisPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HIGH_PRICE")
    private Double highPrice;
    @Column(name = "LOW_PRICE")
    private Double lowPrice;
    @Column(name = "CLOSE_PRICE")
    private Double closePrice;
    @Column(name = "VOLUMN")
    private Integer volumn;
    @Column(name = "OPEN_PRICE")
    private Double openPrice;
    @Column(name = "SETTLE_PRICE")
    private Double settlePrice;
    @Column(name = "OI")
    private Integer oi;
    @Column(name = "LAST_BUY_PRICE")
    private Double lastBuyPrice;
    @Column(name = "LAST_SELL_PRICE")
    private Double lastSellPrice;

    public TbOpHis() {
    }

    public TbOpHis(TbOpHisPK tbOpHisPK) {
        this.tbOpHisPK = tbOpHisPK;
    }

    public TbOpHis(String contract, int excercisePrice, String contractMonth, Date date, String optionType) {
        this.tbOpHisPK = new TbOpHisPK(contract, excercisePrice, contractMonth, date, optionType);
    }

    public TbOpHisPK getTbOpHisPK() {
        return tbOpHisPK;
    }

    public void setTbOpHisPK(TbOpHisPK tbOpHisPK) {
        this.tbOpHisPK = tbOpHisPK;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Integer getVolumn() {
        return volumn;
    }

    public void setVolumn(Integer volumn) {
        this.volumn = volumn;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(Double settlePrice) {
        this.settlePrice = settlePrice;
    }

    public Integer getOi() {
        return oi;
    }

    public void setOi(Integer oi) {
        this.oi = oi;
    }

    public Double getLastBuyPrice() {
        return lastBuyPrice;
    }

    public void setLastBuyPrice(Double lastBuyPrice) {
        this.lastBuyPrice = lastBuyPrice;
    }

    public Double getLastSellPrice() {
        return lastSellPrice;
    }

    public void setLastSellPrice(Double lastSellPrice) {
        this.lastSellPrice = lastSellPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbOpHisPK != null ? tbOpHisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOpHis)) {
            return false;
        }
        TbOpHis other = (TbOpHis) object;
        if ((this.tbOpHisPK == null && other.tbOpHisPK != null) || (this.tbOpHisPK != null && !this.tbOpHisPK.equals(other.tbOpHisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbOpHis[ tbOpHisPK=" + tbOpHisPK + " ]";
    }
    
}
