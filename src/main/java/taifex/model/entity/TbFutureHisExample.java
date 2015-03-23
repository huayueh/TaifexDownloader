package taifex.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbFutureHisExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public TbFutureHisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
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
     * This method corresponds to the database table APP.TB_FUTURE_HIS
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
     * This method corresponds to the database table APP.TB_FUTURE_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_FUTURE_HIS
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
     * This class corresponds to the database table APP.TB_FUTURE_HIS
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

        public Criteria andContractMonthIsNull() {
            addCriterion("\"CONTRACT_MONTH\" is null");
            return (Criteria) this;
        }

        public Criteria andContractMonthIsNotNull() {
            addCriterion("\"CONTRACT_MONTH\" is not null");
            return (Criteria) this;
        }

        public Criteria andContractMonthEqualTo(Integer value) {
            addCriterion("\"CONTRACT_MONTH\" =", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotEqualTo(Integer value) {
            addCriterion("\"CONTRACT_MONTH\" <>", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthGreaterThan(Integer value) {
            addCriterion("\"CONTRACT_MONTH\" >", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"CONTRACT_MONTH\" >=", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthLessThan(Integer value) {
            addCriterion("\"CONTRACT_MONTH\" <", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthLessThanOrEqualTo(Integer value) {
            addCriterion("\"CONTRACT_MONTH\" <=", value, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthIn(List<Integer> values) {
            addCriterion("\"CONTRACT_MONTH\" in", values, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotIn(List<Integer> values) {
            addCriterion("\"CONTRACT_MONTH\" not in", values, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthBetween(Integer value1, Integer value2) {
            addCriterion("\"CONTRACT_MONTH\" between", value1, value2, "contractMonth");
            return (Criteria) this;
        }

        public Criteria andContractMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("\"CONTRACT_MONTH\" not between", value1, value2, "contractMonth");
            return (Criteria) this;
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

        public Criteria andClosePriceIsNull() {
            addCriterion("\"CLOSE_PRICE\" is null");
            return (Criteria) this;
        }

        public Criteria andClosePriceIsNotNull() {
            addCriterion("\"CLOSE_PRICE\" is not null");
            return (Criteria) this;
        }

        public Criteria andClosePriceEqualTo(Integer value) {
            addCriterion("\"CLOSE_PRICE\" =", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceNotEqualTo(Integer value) {
            addCriterion("\"CLOSE_PRICE\" <>", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceGreaterThan(Integer value) {
            addCriterion("\"CLOSE_PRICE\" >", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"CLOSE_PRICE\" >=", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceLessThan(Integer value) {
            addCriterion("\"CLOSE_PRICE\" <", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceLessThanOrEqualTo(Integer value) {
            addCriterion("\"CLOSE_PRICE\" <=", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceIn(List<Integer> values) {
            addCriterion("\"CLOSE_PRICE\" in", values, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceNotIn(List<Integer> values) {
            addCriterion("\"CLOSE_PRICE\" not in", values, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceBetween(Integer value1, Integer value2) {
            addCriterion("\"CLOSE_PRICE\" between", value1, value2, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("\"CLOSE_PRICE\" not between", value1, value2, "closePrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceIsNull() {
            addCriterion("\"UPDOWN_PRICE\" is null");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceIsNotNull() {
            addCriterion("\"UPDOWN_PRICE\" is not null");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceEqualTo(Integer value) {
            addCriterion("\"UPDOWN_PRICE\" =", value, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceNotEqualTo(Integer value) {
            addCriterion("\"UPDOWN_PRICE\" <>", value, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceGreaterThan(Integer value) {
            addCriterion("\"UPDOWN_PRICE\" >", value, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"UPDOWN_PRICE\" >=", value, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceLessThan(Integer value) {
            addCriterion("\"UPDOWN_PRICE\" <", value, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceLessThanOrEqualTo(Integer value) {
            addCriterion("\"UPDOWN_PRICE\" <=", value, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceIn(List<Integer> values) {
            addCriterion("\"UPDOWN_PRICE\" in", values, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceNotIn(List<Integer> values) {
            addCriterion("\"UPDOWN_PRICE\" not in", values, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceBetween(Integer value1, Integer value2) {
            addCriterion("\"UPDOWN_PRICE\" between", value1, value2, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("\"UPDOWN_PRICE\" not between", value1, value2, "updownPrice");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentIsNull() {
            addCriterion("\"UPDOWN_PERCENT\" is null");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentIsNotNull() {
            addCriterion("\"UPDOWN_PERCENT\" is not null");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentEqualTo(Double value) {
            addCriterion("\"UPDOWN_PERCENT\" =", value, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentNotEqualTo(Double value) {
            addCriterion("\"UPDOWN_PERCENT\" <>", value, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentGreaterThan(Double value) {
            addCriterion("\"UPDOWN_PERCENT\" >", value, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentGreaterThanOrEqualTo(Double value) {
            addCriterion("\"UPDOWN_PERCENT\" >=", value, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentLessThan(Double value) {
            addCriterion("\"UPDOWN_PERCENT\" <", value, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentLessThanOrEqualTo(Double value) {
            addCriterion("\"UPDOWN_PERCENT\" <=", value, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentIn(List<Double> values) {
            addCriterion("\"UPDOWN_PERCENT\" in", values, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentNotIn(List<Double> values) {
            addCriterion("\"UPDOWN_PERCENT\" not in", values, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentBetween(Double value1, Double value2) {
            addCriterion("\"UPDOWN_PERCENT\" between", value1, value2, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andUpdownPercentNotBetween(Double value1, Double value2) {
            addCriterion("\"UPDOWN_PERCENT\" not between", value1, value2, "updownPercent");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNull() {
            addCriterion("\"HIGH_PRICE\" is null");
            return (Criteria) this;
        }

        public Criteria andHighPriceIsNotNull() {
            addCriterion("\"HIGH_PRICE\" is not null");
            return (Criteria) this;
        }

        public Criteria andHighPriceEqualTo(Integer value) {
            addCriterion("\"HIGH_PRICE\" =", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotEqualTo(Integer value) {
            addCriterion("\"HIGH_PRICE\" <>", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThan(Integer value) {
            addCriterion("\"HIGH_PRICE\" >", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"HIGH_PRICE\" >=", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThan(Integer value) {
            addCriterion("\"HIGH_PRICE\" <", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceLessThanOrEqualTo(Integer value) {
            addCriterion("\"HIGH_PRICE\" <=", value, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceIn(List<Integer> values) {
            addCriterion("\"HIGH_PRICE\" in", values, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotIn(List<Integer> values) {
            addCriterion("\"HIGH_PRICE\" not in", values, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceBetween(Integer value1, Integer value2) {
            addCriterion("\"HIGH_PRICE\" between", value1, value2, "highPrice");
            return (Criteria) this;
        }

        public Criteria andHighPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("\"HIGH_PRICE\" not between", value1, value2, "highPrice");
            return (Criteria) this;
        }

        public Criteria andVolumnIsNull() {
            addCriterion("\"VOLUMN\" is null");
            return (Criteria) this;
        }

        public Criteria andVolumnIsNotNull() {
            addCriterion("\"VOLUMN\" is not null");
            return (Criteria) this;
        }

        public Criteria andVolumnEqualTo(Integer value) {
            addCriterion("\"VOLUMN\" =", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotEqualTo(Integer value) {
            addCriterion("\"VOLUMN\" <>", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnGreaterThan(Integer value) {
            addCriterion("\"VOLUMN\" >", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"VOLUMN\" >=", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLessThan(Integer value) {
            addCriterion("\"VOLUMN\" <", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLessThanOrEqualTo(Integer value) {
            addCriterion("\"VOLUMN\" <=", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnIn(List<Integer> values) {
            addCriterion("\"VOLUMN\" in", values, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotIn(List<Integer> values) {
            addCriterion("\"VOLUMN\" not in", values, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnBetween(Integer value1, Integer value2) {
            addCriterion("\"VOLUMN\" between", value1, value2, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotBetween(Integer value1, Integer value2) {
            addCriterion("\"VOLUMN\" not between", value1, value2, "volumn");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIsNull() {
            addCriterion("\"SETTLE_PRICE\" is null");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIsNotNull() {
            addCriterion("\"SETTLE_PRICE\" is not null");
            return (Criteria) this;
        }

        public Criteria andSettlePriceEqualTo(Integer value) {
            addCriterion("\"SETTLE_PRICE\" =", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotEqualTo(Integer value) {
            addCriterion("\"SETTLE_PRICE\" <>", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceGreaterThan(Integer value) {
            addCriterion("\"SETTLE_PRICE\" >", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"SETTLE_PRICE\" >=", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceLessThan(Integer value) {
            addCriterion("\"SETTLE_PRICE\" <", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceLessThanOrEqualTo(Integer value) {
            addCriterion("\"SETTLE_PRICE\" <=", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIn(List<Integer> values) {
            addCriterion("\"SETTLE_PRICE\" in", values, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotIn(List<Integer> values) {
            addCriterion("\"SETTLE_PRICE\" not in", values, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceBetween(Integer value1, Integer value2) {
            addCriterion("\"SETTLE_PRICE\" between", value1, value2, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("\"SETTLE_PRICE\" not between", value1, value2, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNull() {
            addCriterion("\"LOW_PRICE\" is null");
            return (Criteria) this;
        }

        public Criteria andLowPriceIsNotNull() {
            addCriterion("\"LOW_PRICE\" is not null");
            return (Criteria) this;
        }

        public Criteria andLowPriceEqualTo(Integer value) {
            addCriterion("\"LOW_PRICE\" =", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotEqualTo(Integer value) {
            addCriterion("\"LOW_PRICE\" <>", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThan(Integer value) {
            addCriterion("\"LOW_PRICE\" >", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"LOW_PRICE\" >=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThan(Integer value) {
            addCriterion("\"LOW_PRICE\" <", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceLessThanOrEqualTo(Integer value) {
            addCriterion("\"LOW_PRICE\" <=", value, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceIn(List<Integer> values) {
            addCriterion("\"LOW_PRICE\" in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotIn(List<Integer> values) {
            addCriterion("\"LOW_PRICE\" not in", values, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceBetween(Integer value1, Integer value2) {
            addCriterion("\"LOW_PRICE\" between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andLowPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("\"LOW_PRICE\" not between", value1, value2, "lowPrice");
            return (Criteria) this;
        }

        public Criteria andOiIsNull() {
            addCriterion("\"OI\" is null");
            return (Criteria) this;
        }

        public Criteria andOiIsNotNull() {
            addCriterion("\"OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andOiEqualTo(Integer value) {
            addCriterion("\"OI\" =", value, "oi");
            return (Criteria) this;
        }

        public Criteria andOiNotEqualTo(Integer value) {
            addCriterion("\"OI\" <>", value, "oi");
            return (Criteria) this;
        }

        public Criteria andOiGreaterThan(Integer value) {
            addCriterion("\"OI\" >", value, "oi");
            return (Criteria) this;
        }

        public Criteria andOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"OI\" >=", value, "oi");
            return (Criteria) this;
        }

        public Criteria andOiLessThan(Integer value) {
            addCriterion("\"OI\" <", value, "oi");
            return (Criteria) this;
        }

        public Criteria andOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"OI\" <=", value, "oi");
            return (Criteria) this;
        }

        public Criteria andOiIn(List<Integer> values) {
            addCriterion("\"OI\" in", values, "oi");
            return (Criteria) this;
        }

        public Criteria andOiNotIn(List<Integer> values) {
            addCriterion("\"OI\" not in", values, "oi");
            return (Criteria) this;
        }

        public Criteria andOiBetween(Integer value1, Integer value2) {
            addCriterion("\"OI\" between", value1, value2, "oi");
            return (Criteria) this;
        }

        public Criteria andOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"OI\" not between", value1, value2, "oi");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIsNull() {
            addCriterion("\"OPEN_PRICE\" is null");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIsNotNull() {
            addCriterion("\"OPEN_PRICE\" is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPriceEqualTo(Integer value) {
            addCriterion("\"OPEN_PRICE\" =", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotEqualTo(Integer value) {
            addCriterion("\"OPEN_PRICE\" <>", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceGreaterThan(Integer value) {
            addCriterion("\"OPEN_PRICE\" >", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"OPEN_PRICE\" >=", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceLessThan(Integer value) {
            addCriterion("\"OPEN_PRICE\" <", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceLessThanOrEqualTo(Integer value) {
            addCriterion("\"OPEN_PRICE\" <=", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIn(List<Integer> values) {
            addCriterion("\"OPEN_PRICE\" in", values, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotIn(List<Integer> values) {
            addCriterion("\"OPEN_PRICE\" not in", values, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceBetween(Integer value1, Integer value2) {
            addCriterion("\"OPEN_PRICE\" between", value1, value2, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("\"OPEN_PRICE\" not between", value1, value2, "openPrice");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table APP.TB_FUTURE_HIS
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
     * This class corresponds to the database table APP.TB_FUTURE_HIS
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