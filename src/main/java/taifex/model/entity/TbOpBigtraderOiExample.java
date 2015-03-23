package taifex.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbOpBigtraderOiExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public TbOpBigtraderOiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDateIsNull() {
            addCriterion("\"DATE\" is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("\"DATE\" is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("\"DATE\" =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("\"DATE\" <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("\"DATE\" >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("\"DATE\" >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("\"DATE\" <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("\"DATE\" <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("\"DATE\" in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("\"DATE\" not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("\"DATE\" between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("\"DATE\" not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andContractIsNull() {
            addCriterion("\"CONTRACT\" is null");
            return (Criteria) this;
        }

        public Criteria andContractIsNotNull() {
            addCriterion("\"CONTRACT\" is not null");
            return (Criteria) this;
        }

        public Criteria andContractEqualTo(String value) {
            addCriterion("\"CONTRACT\" =", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotEqualTo(String value) {
            addCriterion("\"CONTRACT\" <>", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThan(String value) {
            addCriterion("\"CONTRACT\" >", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractGreaterThanOrEqualTo(String value) {
            addCriterion("\"CONTRACT\" >=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThan(String value) {
            addCriterion("\"CONTRACT\" <", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLessThanOrEqualTo(String value) {
            addCriterion("\"CONTRACT\" <=", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractLike(String value) {
            addCriterion("\"CONTRACT\" like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotLike(String value) {
            addCriterion("\"CONTRACT\" not like", value, "contract");
            return (Criteria) this;
        }

        public Criteria andContractIn(List<String> values) {
            addCriterion("\"CONTRACT\" in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotIn(List<String> values) {
            addCriterion("\"CONTRACT\" not in", values, "contract");
            return (Criteria) this;
        }

        public Criteria andContractBetween(String value1, String value2) {
            addCriterion("\"CONTRACT\" between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andContractNotBetween(String value1, String value2) {
            addCriterion("\"CONTRACT\" not between", value1, value2, "contract");
            return (Criteria) this;
        }

        public Criteria andPutCallIsNull() {
            addCriterion("\"PUT_CALL\" is null");
            return (Criteria) this;
        }

        public Criteria andPutCallIsNotNull() {
            addCriterion("\"PUT_CALL\" is not null");
            return (Criteria) this;
        }

        public Criteria andPutCallEqualTo(String value) {
            addCriterion("\"PUT_CALL\" =", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallNotEqualTo(String value) {
            addCriterion("\"PUT_CALL\" <>", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallGreaterThan(String value) {
            addCriterion("\"PUT_CALL\" >", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallGreaterThanOrEqualTo(String value) {
            addCriterion("\"PUT_CALL\" >=", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallLessThan(String value) {
            addCriterion("\"PUT_CALL\" <", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallLessThanOrEqualTo(String value) {
            addCriterion("\"PUT_CALL\" <=", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallLike(String value) {
            addCriterion("\"PUT_CALL\" like", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallNotLike(String value) {
            addCriterion("\"PUT_CALL\" not like", value, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallIn(List<String> values) {
            addCriterion("\"PUT_CALL\" in", values, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallNotIn(List<String> values) {
            addCriterion("\"PUT_CALL\" not in", values, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallBetween(String value1, String value2) {
            addCriterion("\"PUT_CALL\" between", value1, value2, "putCall");
            return (Criteria) this;
        }

        public Criteria andPutCallNotBetween(String value1, String value2) {
            addCriterion("\"PUT_CALL\" not between", value1, value2, "putCall");
            return (Criteria) this;
        }

        public Criteria andContractMonthIsNull() {
            addCriterion("\"CONTRACT_MONTH\" is null");
            return (Criteria) this;
        }

        public Criteria andContractMonthIsNotNull() {
            addCriterion("\"CONTRACT_MONTH\" is not null");
            return (Criteria) this;
        }

        public Criteria andContractMonthEqualTo(String value) {
            addCriterion("\"CONTRACT_MONTH\" =", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotEqualTo(String value) {
            addCriterion("\"CONTRACT_MONTH\" <>", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthGreaterThan(String value) {
            addCriterion("\"CONTRACT_MONTH\" >", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthGreaterThanOrEqualTo(String value) {
            addCriterion("\"CONTRACT_MONTH\" >=", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthLessThan(String value) {
            addCriterion("\"CONTRACT_MONTH\" <", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthLessThanOrEqualTo(String value) {
            addCriterion("\"CONTRACT_MONTH\" <=", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthLike(String value) {
            addCriterion("\"CONTRACT_MONTH\" like", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotLike(String value) {
            addCriterion("\"CONTRACT_MONTH\" not like", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthIn(List<String> values) {
            addCriterion("\"CONTRACT_MONTH\" in", values, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotIn(List<String> values) {
            addCriterion("\"CONTRACT_MONTH\" not in", values, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthBetween(String value1, String value2) {
            addCriterion("\"CONTRACT_MONTH\" between", value1, value2, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotBetween(String value1, String value2) {
            addCriterion("\"CONTRACT_MONTH\" not between", value1, value2, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andTraderTypeIsNull() {
            addCriterion("\"TRADER_TYPE\" is null");
            return (Criteria) this;
        }

        public Criteria andTraderTypeIsNotNull() {
            addCriterion("\"TRADER_TYPE\" is not null");
            return (Criteria) this;
        }

        public Criteria andTraderTypeEqualTo(String value) {
            addCriterion("\"TRADER_TYPE\" =", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeNotEqualTo(String value) {
            addCriterion("\"TRADER_TYPE\" <>", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeGreaterThan(String value) {
            addCriterion("\"TRADER_TYPE\" >", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("\"TRADER_TYPE\" >=", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeLessThan(String value) {
            addCriterion("\"TRADER_TYPE\" <", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeLessThanOrEqualTo(String value) {
            addCriterion("\"TRADER_TYPE\" <=", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeLike(String value) {
            addCriterion("\"TRADER_TYPE\" like", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeNotLike(String value) {
            addCriterion("\"TRADER_TYPE\" not like", value, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeIn(List<String> values) {
            addCriterion("\"TRADER_TYPE\" in", values, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeNotIn(List<String> values) {
            addCriterion("\"TRADER_TYPE\" not in", values, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeBetween(String value1, String value2) {
            addCriterion("\"TRADER_TYPE\" between", value1, value2, "traderType");
            return (Criteria) this;
        }

        public Criteria andTraderTypeNotBetween(String value1, String value2) {
            addCriterion("\"TRADER_TYPE\" not between", value1, value2, "traderType");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("\"CONTRACT_NAME\" is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("\"CONTRACT_NAME\" is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("\"CONTRACT_NAME\" =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("\"CONTRACT_NAME\" <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("\"CONTRACT_NAME\" >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("\"CONTRACT_NAME\" >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("\"CONTRACT_NAME\" <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("\"CONTRACT_NAME\" <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("\"CONTRACT_NAME\" like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("\"CONTRACT_NAME\" not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("\"CONTRACT_NAME\" in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("\"CONTRACT_NAME\" not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("\"CONTRACT_NAME\" between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("\"CONTRACT_NAME\" not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiIsNull() {
            addCriterion("\"TOP5_BUY_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiIsNotNull() {
            addCriterion("\"TOP5_BUY_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiEqualTo(Integer value) {
            addCriterion("\"TOP5_BUY_OI\" =", value, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiNotEqualTo(Integer value) {
            addCriterion("\"TOP5_BUY_OI\" <>", value, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiGreaterThan(Integer value) {
            addCriterion("\"TOP5_BUY_OI\" >", value, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"TOP5_BUY_OI\" >=", value, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiLessThan(Integer value) {
            addCriterion("\"TOP5_BUY_OI\" <", value, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"TOP5_BUY_OI\" <=", value, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiIn(List<Integer> values) {
            addCriterion("\"TOP5_BUY_OI\" in", values, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiNotIn(List<Integer> values) {
            addCriterion("\"TOP5_BUY_OI\" not in", values, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP5_BUY_OI\" between", value1, value2, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5BuyOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP5_BUY_OI\" not between", value1, value2, "top5BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiIsNull() {
            addCriterion("\"TOP5_SELL_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiIsNotNull() {
            addCriterion("\"TOP5_SELL_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiEqualTo(Integer value) {
            addCriterion("\"TOP5_SELL_OI\" =", value, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiNotEqualTo(Integer value) {
            addCriterion("\"TOP5_SELL_OI\" <>", value, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiGreaterThan(Integer value) {
            addCriterion("\"TOP5_SELL_OI\" >", value, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"TOP5_SELL_OI\" >=", value, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiLessThan(Integer value) {
            addCriterion("\"TOP5_SELL_OI\" <", value, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"TOP5_SELL_OI\" <=", value, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiIn(List<Integer> values) {
            addCriterion("\"TOP5_SELL_OI\" in", values, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiNotIn(List<Integer> values) {
            addCriterion("\"TOP5_SELL_OI\" not in", values, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP5_SELL_OI\" between", value1, value2, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop5SellOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP5_SELL_OI\" not between", value1, value2, "top5SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiIsNull() {
            addCriterion("\"TOP10_BUY_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiIsNotNull() {
            addCriterion("\"TOP10_BUY_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiEqualTo(Integer value) {
            addCriterion("\"TOP10_BUY_OI\" =", value, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiNotEqualTo(Integer value) {
            addCriterion("\"TOP10_BUY_OI\" <>", value, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiGreaterThan(Integer value) {
            addCriterion("\"TOP10_BUY_OI\" >", value, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"TOP10_BUY_OI\" >=", value, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiLessThan(Integer value) {
            addCriterion("\"TOP10_BUY_OI\" <", value, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"TOP10_BUY_OI\" <=", value, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiIn(List<Integer> values) {
            addCriterion("\"TOP10_BUY_OI\" in", values, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiNotIn(List<Integer> values) {
            addCriterion("\"TOP10_BUY_OI\" not in", values, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP10_BUY_OI\" between", value1, value2, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10BuyOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP10_BUY_OI\" not between", value1, value2, "top10BuyOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiIsNull() {
            addCriterion("\"TOP10_SELL_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiIsNotNull() {
            addCriterion("\"TOP10_SELL_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiEqualTo(Integer value) {
            addCriterion("\"TOP10_SELL_OI\" =", value, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiNotEqualTo(Integer value) {
            addCriterion("\"TOP10_SELL_OI\" <>", value, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiGreaterThan(Integer value) {
            addCriterion("\"TOP10_SELL_OI\" >", value, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"TOP10_SELL_OI\" >=", value, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiLessThan(Integer value) {
            addCriterion("\"TOP10_SELL_OI\" <", value, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"TOP10_SELL_OI\" <=", value, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiIn(List<Integer> values) {
            addCriterion("\"TOP10_SELL_OI\" in", values, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiNotIn(List<Integer> values) {
            addCriterion("\"TOP10_SELL_OI\" not in", values, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP10_SELL_OI\" between", value1, value2, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andTop10SellOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"TOP10_SELL_OI\" not between", value1, value2, "top10SellOi");
            return (Criteria) this;
        }

        public Criteria andWholeMarketIsNull() {
            addCriterion("\"WHOLE_MARKET\" is null");
            return (Criteria) this;
        }

        public Criteria andWholeMarketIsNotNull() {
            addCriterion("\"WHOLE_MARKET\" is not null");
            return (Criteria) this;
        }

        public Criteria andWholeMarketEqualTo(Integer value) {
            addCriterion("\"WHOLE_MARKET\" =", value, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketNotEqualTo(Integer value) {
            addCriterion("\"WHOLE_MARKET\" <>", value, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketGreaterThan(Integer value) {
            addCriterion("\"WHOLE_MARKET\" >", value, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"WHOLE_MARKET\" >=", value, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketLessThan(Integer value) {
            addCriterion("\"WHOLE_MARKET\" <", value, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketLessThanOrEqualTo(Integer value) {
            addCriterion("\"WHOLE_MARKET\" <=", value, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketIn(List<Integer> values) {
            addCriterion("\"WHOLE_MARKET\" in", values, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketNotIn(List<Integer> values) {
            addCriterion("\"WHOLE_MARKET\" not in", values, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketBetween(Integer value1, Integer value2) {
            addCriterion("\"WHOLE_MARKET\" between", value1, value2, "wholeMarket");
            return (Criteria) this;
        }

        public Criteria andWholeMarketNotBetween(Integer value1, Integer value2) {
            addCriterion("\"WHOLE_MARKET\" not between", value1, value2, "wholeMarket");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 04 17:46:10 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP.TB_OP_BIGTRADER_OI
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}