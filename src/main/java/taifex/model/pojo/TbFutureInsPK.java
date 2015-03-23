/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taifex.model.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Harvey
 */
@Embeddable
public class TbFutureInsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "CONTRACT")
    private String contract;
    @Basic(optional = false)
    @Column(name = "TRADER_TYPE")
    private String traderType;

    public TbFutureInsPK() {
    }

    public TbFutureInsPK(Date date, String contract, String traderType) {
        this.date = new Date(date.getTime());
        this.contract = contract;
        this.traderType = traderType;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getTraderType() {
        return traderType;
    }

    public void setTraderType(String traderType) {
        this.traderType = traderType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        hash += (contract != null ? contract.hashCode() : 0);
        hash += (traderType != null ? traderType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFutureInsPK)) {
            return false;
        }
        TbFutureInsPK other = (TbFutureInsPK) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        if ((this.traderType == null && other.traderType != null) || (this.traderType != null && !this.traderType.equals(other.traderType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbFutureInsPK[ date=" + date + ", contract=" + contract + ", traderType=" + traderType + " ]";
    }
    
}
