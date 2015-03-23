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
public class TbOpHisPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CONTRACT")
    private String contract;
    @Basic(optional = false)
    @Column(name = "EXCERCISE_PRICE")
    private int excercisePrice;
    @Basic(optional = false)
    @Column(name = "CONTRACT_MONTH")
    private String contractMonth;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "OPTION_TYPE")
    private String optionType;

    public TbOpHisPK() {
    }

    public TbOpHisPK(String contract, int excercisePrice, String contractMonth, Date date, String optionType) {
        this.contract = contract;
        this.excercisePrice = excercisePrice;
        this.contractMonth = contractMonth;
        this.date = new Date(date.getTime());
        this.optionType = optionType;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public int getExcercisePrice() {
        return excercisePrice;
    }

    public void setExcercisePrice(int excercisePrice) {
        this.excercisePrice = excercisePrice;
    }

    public String getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(String contractMonth) {
        this.contractMonth = contractMonth;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contract != null ? contract.hashCode() : 0);
        hash += (int) excercisePrice;
        hash += (contractMonth != null ? contractMonth.hashCode() : 0);
        hash += (date != null ? date.hashCode() : 0);
        hash += (optionType != null ? optionType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOpHisPK)) {
            return false;
        }
        TbOpHisPK other = (TbOpHisPK) object;
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        if (this.excercisePrice != other.excercisePrice) {
            return false;
        }
        if ((this.contractMonth == null && other.contractMonth != null) || (this.contractMonth != null && !this.contractMonth.equals(other.contractMonth))) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.optionType == null && other.optionType != null) || (this.optionType != null && !this.optionType.equals(other.optionType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbOpHisPK[ contract=" + contract + ", excercisePrice=" + excercisePrice + ", contractMonth=" + contractMonth + ", date=" + date + ", optionType=" + optionType + " ]";
    }
    
}
