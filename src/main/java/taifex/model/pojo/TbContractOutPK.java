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
public class TbContractOutPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "CONTRACT_MONTH")
    private String contractMonth;
    @Basic(optional = false)
    @Column(name = "CONTRACT")
    private String contract;

    public TbContractOutPK() {
    }

    public TbContractOutPK(Date date, String contractMonth, String contract) {
        this.date = new Date(date.getTime());
        this.contractMonth = contractMonth;
        this.contract = contract;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public String getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(String contractMonth) {
        this.contractMonth = contractMonth;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        hash += (contractMonth != null ? contractMonth.hashCode() : 0);
        hash += (contract != null ? contract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbContractOutPK)) {
            return false;
        }
        TbContractOutPK other = (TbContractOutPK) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.contractMonth == null && other.contractMonth != null) || (this.contractMonth != null && !this.contractMonth.equals(other.contractMonth))) {
            return false;
        }
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbContractOutPK[ date=" + date + ", contractMonth=" + contractMonth + ", contract=" + contract + " ]";
    }
    
}
