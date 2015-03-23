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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author Harvey
 */
@Entity
@Table(name = "TB_INDEX")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbIndex.findAll", query = "SELECT t FROM TbIndex t"),
    @NamedQuery(name = "TbIndex.findByDate", query = "SELECT t FROM TbIndex t WHERE t.date = :date"),
    @NamedQuery(name = "TbIndex.findByEma2", query = "SELECT t FROM TbIndex t WHERE t.ema2 = :ema2"),
    @NamedQuery(name = "TbIndex.findByAlliGreen", query = "SELECT t FROM TbIndex t WHERE t.alliGreen = :alliGreen"),
    @NamedQuery(name = "TbIndex.findByEma1", query = "SELECT t FROM TbIndex t WHERE t.ema1 = :ema1"),
    @NamedQuery(name = "TbIndex.findByAlliRed", query = "SELECT t FROM TbIndex t WHERE t.alliRed = :alliRed"),
    @NamedQuery(name = "TbIndex.findByAlliBlue", query = "SELECT t FROM TbIndex t WHERE t.alliBlue = :alliBlue")})
public class TbIndex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EMA2")
    private Double ema2;
    @Column(name = "ALLI_GREEN")
    private Double alliGreen;
    @Column(name = "EMA1")
    private Double ema1;
    @Column(name = "ALLI_RED")
    private Double alliRed;
    @Column(name = "ALLI_BLUE")
    private Double alliBlue;

    public TbIndex() {
    }

    public TbIndex(Date date) {
        this.date = new Date(date.getTime());
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public Double getEma2() {
        return ema2;
    }

    public void setEma2(Double ema2) {
        this.ema2 = ema2;
    }

    public Double getAlliGreen() {
        return alliGreen;
    }

    public void setAlliGreen(Double alliGreen) {
        this.alliGreen = alliGreen;
    }

    public Double getEma1() {
        return ema1;
    }

    public void setEma1(Double ema1) {
        this.ema1 = ema1;
    }

    public Double getAlliRed() {
        return alliRed;
    }

    public void setAlliRed(Double alliRed) {
        this.alliRed = alliRed;
    }

    public Double getAlliBlue() {
        return alliBlue;
    }

    public void setAlliBlue(Double alliBlue) {
        this.alliBlue = alliBlue;
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
        if (!(object instanceof TbIndex)) {
            return false;
        }
        TbIndex other = (TbIndex) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbIndex[ date=" + date + " ]";
    }
    
}
