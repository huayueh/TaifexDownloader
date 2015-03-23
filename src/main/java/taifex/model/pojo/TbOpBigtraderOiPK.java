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
public class TbOpBigtraderOiPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "CONTRACT")
    private String contract;
    @Basic(optional = false)
    @Column(name = "PUT_CALL")
    private String putCall;
    @Basic(optional = false)
    @Column(name = "CONTRACT_MONTH")
    private String contractMonth;
    @Basic(optional = false)
    @Column(name = "TRADER_TYPE")
    private String traderType;

    public TbOpBigtraderOiPK() {
    }

    public TbOpBigtraderOiPK(Date date, String contract, String putCall, String contractMonth, String traderType) {
        this.date = new Date(date.getTime());
        this.contract = contract;
        this.putCall = putCall;
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

    public String getPutCall() {
        return putCall;
    }

    public void setPutCall(String putCall) {
        this.putCall = putCall;
    }

    public String getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(String contractMonth) {
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
        hash += (putCall != null ? putCall.hashCode() : 0);
        hash += (contractMonth != null ? contractMonth.hashCode() : 0);
        hash += (traderType != null ? traderType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOpBigtraderOiPK)) {
            return false;
        }
        TbOpBigtraderOiPK other = (TbOpBigtraderOiPK) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        if ((this.putCall == null && other.putCall != null) || (this.putCall != null && !this.putCall.equals(other.putCall))) {
            return false;
        }
        if ((this.contractMonth == null && other.contractMonth != null) || (this.contractMonth != null && !this.contractMonth.equals(other.contractMonth))) {
            return false;
        }
        if ((this.traderType == null && other.traderType != null) || (this.traderType != null && !this.traderType.equals(other.traderType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbOpBigtraderOiPK[ date=" + date + ", contract=" + contract + ", putCall=" + putCall + ", contractMonth=" + contractMonth + ", traderType=" + traderType + " ]";
    }
    
}
