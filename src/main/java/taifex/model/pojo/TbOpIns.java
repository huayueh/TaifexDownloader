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
@Table(name = "TB_OP_INS")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOpIns.findAll", query = "SELECT t FROM TbOpIns t"),
    @NamedQuery(name = "TbOpIns.findByDate", query = "SELECT t FROM TbOpIns t WHERE t.tbOpInsPK.date = :date"),
    @NamedQuery(name = "TbOpIns.findByContract", query = "SELECT t FROM TbOpIns t WHERE t.tbOpInsPK.contract = :contract"),
    @NamedQuery(name = "TbOpIns.findByBuyCall", query = "SELECT t FROM TbOpIns t WHERE t.tbOpInsPK.buyCall = :buyCall"),
    @NamedQuery(name = "TbOpIns.findByTraderType", query = "SELECT t FROM TbOpIns t WHERE t.tbOpInsPK.traderType = :traderType"),
    @NamedQuery(name = "TbOpIns.findByBuyAmt", query = "SELECT t FROM TbOpIns t WHERE t.buyAmt = :buyAmt"),
    @NamedQuery(name = "TbOpIns.findByBuyCnt", query = "SELECT t FROM TbOpIns t WHERE t.buyCnt = :buyCnt"),
    @NamedQuery(name = "TbOpIns.findBySellAmt", query = "SELECT t FROM TbOpIns t WHERE t.sellAmt = :sellAmt"),
    @NamedQuery(name = "TbOpIns.findBySellCnt", query = "SELECT t FROM TbOpIns t WHERE t.sellCnt = :sellCnt"),
    @NamedQuery(name = "TbOpIns.findByCntNet", query = "SELECT t FROM TbOpIns t WHERE t.cntNet = :cntNet"),
    @NamedQuery(name = "TbOpIns.findByAmtNet", query = "SELECT t FROM TbOpIns t WHERE t.amtNet = :amtNet"),
    @NamedQuery(name = "TbOpIns.findByBuyOiCnt", query = "SELECT t FROM TbOpIns t WHERE t.buyOiCnt = :buyOiCnt"),
    @NamedQuery(name = "TbOpIns.findByBuyOiAmt", query = "SELECT t FROM TbOpIns t WHERE t.buyOiAmt = :buyOiAmt"),
    @NamedQuery(name = "TbOpIns.findBySellOiCnt", query = "SELECT t FROM TbOpIns t WHERE t.sellOiCnt = :sellOiCnt"),
    @NamedQuery(name = "TbOpIns.findBySellOiAmt", query = "SELECT t FROM TbOpIns t WHERE t.sellOiAmt = :sellOiAmt"),
    @NamedQuery(name = "TbOpIns.findByCntOiNet", query = "SELECT t FROM TbOpIns t WHERE t.cntOiNet = :cntOiNet"),
    @NamedQuery(name = "TbOpIns.findByAmtOiNet", query = "SELECT t FROM TbOpIns t WHERE t.amtOiNet = :amtOiNet")})
public class TbOpIns implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbOpInsPK tbOpInsPK;
    @Column(name = "BUY_AMT")
    private Integer buyAmt;
    @Column(name = "BUY_CNT")
    private Integer buyCnt;
    @Column(name = "SELL_AMT")
    private Integer sellAmt;
    @Column(name = "SELL_CNT")
    private Integer sellCnt;
    @Column(name = "CNT_NET")
    private Integer cntNet;
    @Column(name = "AMT_NET")
    private Integer amtNet;
    @Column(name = "BUY_OI_CNT")
    private Integer buyOiCnt;
    @Column(name = "BUY_OI_AMT")
    private Integer buyOiAmt;
    @Column(name = "SELL_OI_CNT")
    private Integer sellOiCnt;
    @Column(name = "SELL_OI_AMT")
    private Integer sellOiAmt;
    @Column(name = "CNT_OI_NET")
    private Integer cntOiNet;
    @Column(name = "AMT_OI_NET")
    private Integer amtOiNet;

    public TbOpIns() {
    }

    public TbOpIns(TbOpInsPK tbOpInsPK) {
        this.tbOpInsPK = tbOpInsPK;
    }

    public TbOpIns(Date date, String contract, String buyCall, String traderType) {
        this.tbOpInsPK = new TbOpInsPK(date, contract, buyCall, traderType);
    }

    public TbOpInsPK getTbOpInsPK() {
        return tbOpInsPK;
    }

    public void setTbOpInsPK(TbOpInsPK tbOpInsPK) {
        this.tbOpInsPK = tbOpInsPK;
    }

    public Integer getBuyAmt() {
        return buyAmt;
    }

    public void setBuyAmt(Integer buyAmt) {
        this.buyAmt = buyAmt;
    }

    public Integer getBuyCnt() {
        return buyCnt;
    }

    public void setBuyCnt(Integer buyCnt) {
        this.buyCnt = buyCnt;
    }

    public Integer getSellAmt() {
        return sellAmt;
    }

    public void setSellAmt(Integer sellAmt) {
        this.sellAmt = sellAmt;
    }

    public Integer getSellCnt() {
        return sellCnt;
    }

    public void setSellCnt(Integer sellCnt) {
        this.sellCnt = sellCnt;
    }

    public Integer getCntNet() {
        return cntNet;
    }

    public void setCntNet(Integer cntNet) {
        this.cntNet = cntNet;
    }

    public Integer getAmtNet() {
        return amtNet;
    }

    public void setAmtNet(Integer amtNet) {
        this.amtNet = amtNet;
    }

    public Integer getBuyOiCnt() {
        return buyOiCnt;
    }

    public void setBuyOiCnt(Integer buyOiCnt) {
        this.buyOiCnt = buyOiCnt;
    }

    public Integer getBuyOiAmt() {
        return buyOiAmt;
    }

    public void setBuyOiAmt(Integer buyOiAmt) {
        this.buyOiAmt = buyOiAmt;
    }

    public Integer getSellOiCnt() {
        return sellOiCnt;
    }

    public void setSellOiCnt(Integer sellOiCnt) {
        this.sellOiCnt = sellOiCnt;
    }

    public Integer getSellOiAmt() {
        return sellOiAmt;
    }

    public void setSellOiAmt(Integer sellOiAmt) {
        this.sellOiAmt = sellOiAmt;
    }

    public Integer getCntOiNet() {
        return cntOiNet;
    }

    public void setCntOiNet(Integer cntOiNet) {
        this.cntOiNet = cntOiNet;
    }

    public Integer getAmtOiNet() {
        return amtOiNet;
    }

    public void setAmtOiNet(Integer amtOiNet) {
        this.amtOiNet = amtOiNet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbOpInsPK != null ? tbOpInsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOpIns)) {
            return false;
        }
        TbOpIns other = (TbOpIns) object;
        if ((this.tbOpInsPK == null && other.tbOpInsPK != null) || (this.tbOpInsPK != null && !this.tbOpInsPK.equals(other.tbOpInsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taifex.model.pojo.TbOpIns[ tbOpInsPK=" + tbOpInsPK + " ]";
    }
    
}
