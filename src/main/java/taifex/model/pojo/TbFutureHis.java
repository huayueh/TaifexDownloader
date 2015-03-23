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
@Table(name = "TB_FUTURE_HIS")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFutureHis.findAll", query = "SELECT t FROM TbFutureHis t"),
    @NamedQuery(name = "TbFutureHis.findByClosePrice", query = "SELECT t FROM TbFutureHis t WHERE t.closePrice = :closePrice"),
    @NamedQuery(name = "TbFutureHis.findByUpdownPrice", query = "SELECT t FROM TbFutureHis t WHERE t.updownPrice = :updownPrice"),
    @NamedQuery(name = "TbFutureHis.findByContractMonth", query = "SELECT t FROM TbFutureHis t WHERE t.tbFutureHisPK.contractMonth = :contractMonth"),
    @NamedQuery(name = "TbFutureHis.findByUpdownPercent", query = "SELECT t FROM TbFutureHis t WHERE t.updownPercent = :updownPercent"),
    @NamedQuery(name = "TbFutureHis.findByHighPrice", query = "SELECT t FROM TbFutureHis t WHERE t.highPrice = :highPrice"),
    @NamedQuery(name = "TbFutureHis.findByVolumn", query = "SELECT t FROM TbFutureHis t WHERE t.volumn = :volumn"),
    @NamedQuery(name = "TbFutureHis.findByContract", query = "SELECT t FROM TbFutureHis t WHERE t.tbFutureHisPK.contract = :contract"),
    @NamedQuery(name = "TbFutureHis.findBySettlePrice", query = "SELECT t FROM TbFutureHis t WHERE t.settlePrice = :settlePrice"),
    @NamedQuery(name = "TbFutureHis.findByLowPrice", query = "SELECT t FROM TbFutureHis t WHERE t.lowPrice = :lowPrice"),
    @NamedQuery(name = "TbFutureHis.findByOi", query = "SELECT t FROM TbFutureHis t WHERE t.oi = :oi"),
    @NamedQuery(name = "TbFutureHis.findByOpenPrice", query = "SELECT t FROM TbFutureHis t WHERE t.openPrice = :openPrice"),
    @NamedQuery(name = "TbFutureHis.findByDate", query = "SELECT t FROM TbFutureHis t WHERE t.tbFutureHisPK.date = :date")})
public class TbFutureHis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbFutureHisPK tbFutureHisPK;
    @Column(name = "CLOSE_PRICE")
    private Integer closePrice;
    @Column(name = "UPDOWN_PRICE")
    private Integer updownPrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UPDOWN_PERCENT")
    private Double updownPercent;
    @Column(name = "HIGH_PRICE")
    private Integer highPrice;
    @Column(name = "VOLUMN")
    private Integer volumn;
    @Column(name = "SETTLE_PRICE")
    private Integer settlePrice;
    @Column(name = "LOW_PRICE")
    private Integer lowPrice;
    @Column(name = "OI")
    private Integer oi;
    @Column(name = "OPEN_PRICE")
    private Integer openPrice;

    public TbFutureHis() {
    }

    public TbFutureHis(TbFutureHisPK tbFutureHisPK) {
        this.tbFutureHisPK = tbFutureHisPK;
    }

    public TbFutureHis(int contractMonth, String contract, Date date) {
        this.tbFutureHisPK = new TbFutureHisPK(contractMonth, contract, date);
    }

    public TbFutureHisPK getTbFutureHisPK() {
        return tbFutureHisPK;
    }

    public void setTbFutureHisPK(TbFutureHisPK tbFutureHisPK) {
        this.tbFutureHisPK = tbFutureHisPK;
    }

    public Integer getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Integer closePrice) {
        this.closePrice = closePrice;
    }

    public Integer getUpdownPrice() {
        return updownPrice;
    }

    public void setUpdownPrice(Integer updownPrice) {
        this.updownPrice = updownPrice;
    }

    public Double getUpdownPercent() {
        return updownPercent;
    }

    public void setUpdownPercent(Double updownPercent) {
        this.updownPercent = updownPercent;
    }

    public Integer getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Integer highPrice) {
        this.highPrice = highPrice;
    }

    public Integer getVolumn() {
        return volumn;
    }

    public void setVolumn(Integer volumn) {
        this.volumn = volumn;
    }

    public Integer getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(Integer settlePrice) {
        this.settlePrice = settlePrice;
    }

    public Integer getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Integer lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Integer getOi() {
        return oi;
    }

    public void setOi(Integer oi) {
        this.oi = oi;
    }

    public Integer getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Integer openPrice) {
        this.openPrice = openPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbFutureHisPK != null ? tbFutureHisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFutureHis)) {
            return false;
        }
        TbFutureHis other = (TbFutureHis) object;
        if ((this.tbFutureHisPK == null && other.tbFutureHisPK != null) || (this.tbFutureHisPK != null && !this.tbFutureHisPK.equals(other.tbFutureHisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbFutureHis[ tbFutureHisPK=" + tbFutureHisPK + " ]";
    }
    
}
