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
@Table(name = "TB_CONTRACT_OUT")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbContractOut.findAll", query = "SELECT t FROM TbContractOut t"),
    @NamedQuery(name = "TbContractOut.findByDate", query = "SELECT t FROM TbContractOut t WHERE t.tbContractOutPK.date = :date"),
    @NamedQuery(name = "TbContractOut.findByContractMonth", query = "SELECT t FROM TbContractOut t WHERE t.tbContractOutPK.contractMonth = :contractMonth"),
    @NamedQuery(name = "TbContractOut.findByContract", query = "SELECT t FROM TbContractOut t WHERE t.tbContractOutPK.contract = :contract"),
    @NamedQuery(name = "TbContractOut.findByContractName", query = "SELECT t FROM TbContractOut t WHERE t.contractName = :contractName"),
    @NamedQuery(name = "TbContractOut.findByPrice", query = "SELECT t FROM TbContractOut t WHERE t.price = :price")})
public class TbContractOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbContractOutPK tbContractOutPK;
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public TbContractOut() {
    }

    public TbContractOut(TbContractOutPK tbContractOutPK) {
        this.tbContractOutPK = tbContractOutPK;
    }

    public TbContractOut(Date date, String contractMonth, String contract) {
        this.tbContractOutPK = new TbContractOutPK(date, contractMonth, contract);
    }

    public TbContractOutPK getTbContractOutPK() {
        return tbContractOutPK;
    }

    public void setTbContractOutPK(TbContractOutPK tbContractOutPK) {
        this.tbContractOutPK = tbContractOutPK;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbContractOutPK != null ? tbContractOutPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbContractOut)) {
            return false;
        }
        TbContractOut other = (TbContractOut) object;
        if ((this.tbContractOutPK == null && other.tbContractOutPK != null) || (this.tbContractOutPK != null && !this.tbContractOutPK.equals(other.tbContractOutPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbContractOut[ tbContractOutPK=" + tbContractOutPK + " ]";
    }
    
}
