/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taifex.model.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harvey
 */
@Entity
@Table(name = "TB_TWII_HIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTwiiHis.findAll", query = "SELECT t FROM TbTwiiHis t"),
    @NamedQuery(name = "TbTwiiHis.findByDate", query = "SELECT t FROM TbTwiiHis t WHERE t.date = :date"),
    @NamedQuery(name = "TbTwiiHis.findByOpenPrice", query = "SELECT t FROM TbTwiiHis t WHERE t.openPrice = :openPrice"),
    @NamedQuery(name = "TbTwiiHis.findByHighPrice", query = "SELECT t FROM TbTwiiHis t WHERE t.highPrice = :highPrice"),
    @NamedQuery(name = "TbTwiiHis.findByLowPrice", query = "SELECT t FROM TbTwiiHis t WHERE t.lowPrice = :lowPrice"),
    @NamedQuery(name = "TbTwiiHis.findByClosePrice", query = "SELECT t FROM TbTwiiHis t WHERE t.closePrice = :closePrice"),
    @NamedQuery(name = "TbTwiiHis.findByVolume", query = "SELECT t FROM TbTwiiHis t WHERE t.volume = :volume"),
    @NamedQuery(name = "TbTwiiHis.findByAdjClosePrice", query = "SELECT t FROM TbTwiiHis t WHERE t.adjClosePrice = :adjClosePrice")})
public class TbTwiiHis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OPEN_PRICE")
    private Double openPrice;
    @Column(name = "HIGH_PRICE")
    private Double highPrice;
    @Column(name = "LOW_PRICE")
    private Double lowPrice;
    @Column(name = "CLOSE_PRICE")
    private Double closePrice;
    @Column(name = "VOLUME")
    private Double volume;
    @Column(name = "ADJ_CLOSE_PRICE")
    private Double adjClosePrice;

    public TbTwiiHis() {
    }

    public TbTwiiHis(Date date) {
        this.date = new Date(date.getTime());
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
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

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAdjClosePrice() {
        return adjClosePrice;
    }

    public void setAdjClosePrice(Double adjClosePrice) {
        this.adjClosePrice = adjClosePrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTwiiHis)) {
            return false;
        }
        TbTwiiHis other = (TbTwiiHis) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbTwiiHis[ date=" + date + " ]";
    }
    
}
