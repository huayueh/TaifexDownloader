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
public class TbFutureHisPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CONTRACT_MONTH")
    private int contractMonth;
    @Basic(optional = false)
    @Column(name = "CONTRACT")
    private String contract;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public TbFutureHisPK() {
    }

    public TbFutureHisPK(int contractMonth, String contract, Date date) {
        this.contractMonth = contractMonth;
        this.contract = contract;
        this.date = new Date(date.getTime());
    }

    public int getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(int contractMonth) {
        this.contractMonth = contractMonth;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) contractMonth;
        hash += (contract != null ? contract.hashCode() : 0);
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFutureHisPK)) {
            return false;
        }
        TbFutureHisPK other = (TbFutureHisPK) object;
        if (this.contractMonth != other.contractMonth) {
            return false;
        }
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbFutureHisPK[ contractMonth=" + contractMonth + ", contract=" + contract + ", date=" + date + " ]";
    }
    
}
