package taifex.model.entity;

import java.util.Date;

public class TbContractOutKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP.TB_CONTRACT_OUT.DATE
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP.TB_CONTRACT_OUT.CONTRACT_MONTH
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    private String contractMonth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column APP.TB_CONTRACT_OUT.CONTRACT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    private String contract;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP.TB_CONTRACT_OUT.DATE
     *
     * @return the value of APP.TB_CONTRACT_OUT.DATE
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP.TB_CONTRACT_OUT.DATE
     *
     * @param date the value for APP.TB_CONTRACT_OUT.DATE
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP.TB_CONTRACT_OUT.CONTRACT_MONTH
     *
     * @return the value of APP.TB_CONTRACT_OUT.CONTRACT_MONTH
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public String getContractMonth() {
        return contractMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP.TB_CONTRACT_OUT.CONTRACT_MONTH
     *
     * @param contractMonth the value for APP.TB_CONTRACT_OUT.CONTRACT_MONTH
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setContractMonth(String contractMonth) {
        this.contractMonth = contractMonth == null ? null : contractMonth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column APP.TB_CONTRACT_OUT.CONTRACT
     *
     * @return the value of APP.TB_CONTRACT_OUT.CONTRACT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public String getContract() {
        return contract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column APP.TB_CONTRACT_OUT.CONTRACT
     *
     * @param contract the value for APP.TB_CONTRACT_OUT.CONTRACT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setContract(String contract) {
        this.contract = contract == null ? null : contract.trim();
    }
}