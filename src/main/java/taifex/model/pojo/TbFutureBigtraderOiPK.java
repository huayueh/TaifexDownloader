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
public class TbFutureBigtraderOiPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "CONTRACT")
    private String contract;
    @Basic(optional = false)
    @Column(name = "CONTRACT_MONTH")
    private int contractMonth;
    @Basic(optional = false)
    @Column(name = "TRADER_TYPE")
    private String traderType;

    public TbFutureBigtraderOiPK() {
    }

    public TbFutureBigtraderOiPK(Date date, String contract, int contractMonth, String traderType) {
        this.date = new Date(date.getTime());
        this.contract = contract;
        this.contractMonth = contractMonth;
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

    public int getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(int contractMonth) {
        this.contractMonth = contractMonth;
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
        hash += (int) contractMonth;
        hash += (traderType != null ? traderType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFutureBigtraderOiPK)) {
            return false;
        }
        TbFutureBigtraderOiPK other = (TbFutureBigtraderOiPK) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        if (this.contractMonth != other.contractMonth) {
            return false;
        }
        if ((this.traderType == null && other.traderType != null) || (this.traderType != null && !this.traderType.equals(other.traderType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbFutureBigtraderOiPK[ date=" + date + ", contract=" + contract + ", contractMonth=" + contractMonth + ", traderType=" + traderType + " ]";
    }
    
}
