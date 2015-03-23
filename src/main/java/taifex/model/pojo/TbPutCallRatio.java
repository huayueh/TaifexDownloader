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
@Table(name = "TB_PUT_CALL_RATIO")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPutCallRatio.findAll", query = "SELECT t FROM TbPutCallRatio t"),
    @NamedQuery(name = "TbPutCallRatio.findByDate", query = "SELECT t FROM TbPutCallRatio t WHERE t.date = :date"),
    @NamedQuery(name = "TbPutCallRatio.findByPutVol", query = "SELECT t FROM TbPutCallRatio t WHERE t.putVol = :putVol"),
    @NamedQuery(name = "TbPutCallRatio.findByCallVol", query = "SELECT t FROM TbPutCallRatio t WHERE t.callVol = :callVol"),
    @NamedQuery(name = "TbPutCallRatio.findByPutCallRationVol", query = "SELECT t FROM TbPutCallRatio t WHERE t.putCallRationVol = :putCallRationVol"),
    @NamedQuery(name = "TbPutCallRatio.findByPutOi", query = "SELECT t FROM TbPutCallRatio t WHERE t.putOi = :putOi"),
    @NamedQuery(name = "TbPutCallRatio.findByCallOi", query = "SELECT t FROM TbPutCallRatio t WHERE t.callOi = :callOi"),
    @NamedQuery(name = "TbPutCallRatio.findByPutCallRatioOi", query = "SELECT t FROM TbPutCallRatio t WHERE t.putCallRatioOi = :putCallRatioOi")})
public class TbPutCallRatio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "PUT_VOL")
    private Integer putVol;
    @Column(name = "CALL_VOL")
    private Integer callVol;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PUT_CALL_RATION_VOL")
    private Double putCallRationVol;
    @Column(name = "PUT_OI")
    private Integer putOi;
    @Column(name = "CALL_OI")
    private Integer callOi;
    @Column(name = "PUT_CALL_RATIO_OI")
    private Double putCallRatioOi;

    public TbPutCallRatio() {
    }

    public TbPutCallRatio(Date date) {
        this.date = new Date(date.getTime());
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public Integer getPutVol() {
        return putVol;
    }

    public void setPutVol(Integer putVol) {
        this.putVol = putVol;
    }

    public Integer getCallVol() {
        return callVol;
    }

    public void setCallVol(Integer callVol) {
        this.callVol = callVol;
    }

    public Double getPutCallRationVol() {
        return putCallRationVol;
    }

    public void setPutCallRationVol(Double putCallRationVol) {
        this.putCallRationVol = putCallRationVol;
    }

    public Integer getPutOi() {
        return putOi;
    }

    public void setPutOi(Integer putOi) {
        this.putOi = putOi;
    }

    public Integer getCallOi() {
        return callOi;
    }

    public void setCallOi(Integer callOi) {
        this.callOi = callOi;
    }

    public Double getPutCallRatioOi() {
        return putCallRatioOi;
    }

    public void setPutCallRatioOi(Double putCallRatioOi) {
        this.putCallRatioOi = putCallRatioOi;
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
        if (!(object instanceof TbPutCallRatio)) {
            return false;
        }
        TbPutCallRatio other = (TbPutCallRatio) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbPutCallRatio[ date=" + date + " ]";
    }
    
}
