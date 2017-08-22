package taifex.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbPutCallRatioExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public TbPutCallRatioExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
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
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
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
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
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
     * This class corresponds to the database name APP.TB_PUT_CALL_RATIO
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

        public Criteria andPutVolIsNull() {
            addCriterion("\"PUT_VOL\" is null");
            return (Criteria) this;
        }

        public Criteria andPutVolIsNotNull() {
            addCriterion("\"PUT_VOL\" is not null");
            return (Criteria) this;
        }

        public Criteria andPutVolEqualTo(Integer value) {
            addCriterion("\"PUT_VOL\" =", value, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolNotEqualTo(Integer value) {
            addCriterion("\"PUT_VOL\" <>", value, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolGreaterThan(Integer value) {
            addCriterion("\"PUT_VOL\" >", value, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"PUT_VOL\" >=", value, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolLessThan(Integer value) {
            addCriterion("\"PUT_VOL\" <", value, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolLessThanOrEqualTo(Integer value) {
            addCriterion("\"PUT_VOL\" <=", value, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolIn(List<Integer> values) {
            addCriterion("\"PUT_VOL\" in", values, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolNotIn(List<Integer> values) {
            addCriterion("\"PUT_VOL\" not in", values, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolBetween(Integer value1, Integer value2) {
            addCriterion("\"PUT_VOL\" between", value1, value2, "putVol");
            return (Criteria) this;
        }

        public Criteria andPutVolNotBetween(Integer value1, Integer value2) {
            addCriterion("\"PUT_VOL\" not between", value1, value2, "putVol");
            return (Criteria) this;
        }

        public Criteria andCallVolIsNull() {
            addCriterion("\"CALL_VOL\" is null");
            return (Criteria) this;
        }

        public Criteria andCallVolIsNotNull() {
            addCriterion("\"CALL_VOL\" is not null");
            return (Criteria) this;
        }

        public Criteria andCallVolEqualTo(Integer value) {
            addCriterion("\"CALL_VOL\" =", value, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolNotEqualTo(Integer value) {
            addCriterion("\"CALL_VOL\" <>", value, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolGreaterThan(Integer value) {
            addCriterion("\"CALL_VOL\" >", value, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"CALL_VOL\" >=", value, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolLessThan(Integer value) {
            addCriterion("\"CALL_VOL\" <", value, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolLessThanOrEqualTo(Integer value) {
            addCriterion("\"CALL_VOL\" <=", value, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolIn(List<Integer> values) {
            addCriterion("\"CALL_VOL\" in", values, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolNotIn(List<Integer> values) {
            addCriterion("\"CALL_VOL\" not in", values, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolBetween(Integer value1, Integer value2) {
            addCriterion("\"CALL_VOL\" between", value1, value2, "callVol");
            return (Criteria) this;
        }

        public Criteria andCallVolNotBetween(Integer value1, Integer value2) {
            addCriterion("\"CALL_VOL\" not between", value1, value2, "callVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolIsNull() {
            addCriterion("\"PUT_CALL_RATION_VOL\" is null");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolIsNotNull() {
            addCriterion("\"PUT_CALL_RATION_VOL\" is not null");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATION_VOL\" =", value, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolNotEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATION_VOL\" <>", value, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolGreaterThan(Double value) {
            addCriterion("\"PUT_CALL_RATION_VOL\" >", value, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolGreaterThanOrEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATION_VOL\" >=", value, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolLessThan(Double value) {
            addCriterion("\"PUT_CALL_RATION_VOL\" <", value, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolLessThanOrEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATION_VOL\" <=", value, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolIn(List<Double> values) {
            addCriterion("\"PUT_CALL_RATION_VOL\" in", values, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolNotIn(List<Double> values) {
            addCriterion("\"PUT_CALL_RATION_VOL\" not in", values, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolBetween(Double value1, Double value2) {
            addCriterion("\"PUT_CALL_RATION_VOL\" between", value1, value2, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutCallRationVolNotBetween(Double value1, Double value2) {
            addCriterion("\"PUT_CALL_RATION_VOL\" not between", value1, value2, "putCallRationVol");
            return (Criteria) this;
        }

        public Criteria andPutOiIsNull() {
            addCriterion("\"PUT_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andPutOiIsNotNull() {
            addCriterion("\"PUT_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andPutOiEqualTo(Integer value) {
            addCriterion("\"PUT_OI\" =", value, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiNotEqualTo(Integer value) {
            addCriterion("\"PUT_OI\" <>", value, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiGreaterThan(Integer value) {
            addCriterion("\"PUT_OI\" >", value, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"PUT_OI\" >=", value, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiLessThan(Integer value) {
            addCriterion("\"PUT_OI\" <", value, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"PUT_OI\" <=", value, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiIn(List<Integer> values) {
            addCriterion("\"PUT_OI\" in", values, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiNotIn(List<Integer> values) {
            addCriterion("\"PUT_OI\" not in", values, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiBetween(Integer value1, Integer value2) {
            addCriterion("\"PUT_OI\" between", value1, value2, "putOi");
            return (Criteria) this;
        }

        public Criteria andPutOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"PUT_OI\" not between", value1, value2, "putOi");
            return (Criteria) this;
        }

        public Criteria andCallOiIsNull() {
            addCriterion("\"CALL_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andCallOiIsNotNull() {
            addCriterion("\"CALL_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andCallOiEqualTo(Integer value) {
            addCriterion("\"CALL_OI\" =", value, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiNotEqualTo(Integer value) {
            addCriterion("\"CALL_OI\" <>", value, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiGreaterThan(Integer value) {
            addCriterion("\"CALL_OI\" >", value, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"CALL_OI\" >=", value, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiLessThan(Integer value) {
            addCriterion("\"CALL_OI\" <", value, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiLessThanOrEqualTo(Integer value) {
            addCriterion("\"CALL_OI\" <=", value, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiIn(List<Integer> values) {
            addCriterion("\"CALL_OI\" in", values, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiNotIn(List<Integer> values) {
            addCriterion("\"CALL_OI\" not in", values, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiBetween(Integer value1, Integer value2) {
            addCriterion("\"CALL_OI\" between", value1, value2, "callOi");
            return (Criteria) this;
        }

        public Criteria andCallOiNotBetween(Integer value1, Integer value2) {
            addCriterion("\"CALL_OI\" not between", value1, value2, "callOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiIsNull() {
            addCriterion("\"PUT_CALL_RATIO_OI\" is null");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiIsNotNull() {
            addCriterion("\"PUT_CALL_RATIO_OI\" is not null");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATIO_OI\" =", value, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiNotEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATIO_OI\" <>", value, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiGreaterThan(Double value) {
            addCriterion("\"PUT_CALL_RATIO_OI\" >", value, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiGreaterThanOrEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATIO_OI\" >=", value, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiLessThan(Double value) {
            addCriterion("\"PUT_CALL_RATIO_OI\" <", value, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiLessThanOrEqualTo(Double value) {
            addCriterion("\"PUT_CALL_RATIO_OI\" <=", value, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiIn(List<Double> values) {
            addCriterion("\"PUT_CALL_RATIO_OI\" in", values, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiNotIn(List<Double> values) {
            addCriterion("\"PUT_CALL_RATIO_OI\" not in", values, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiBetween(Double value1, Double value2) {
            addCriterion("\"PUT_CALL_RATIO_OI\" between", value1, value2, "putCallRatioOi");
            return (Criteria) this;
        }

        public Criteria andPutCallRatioOiNotBetween(Double value1, Double value2) {
            addCriterion("\"PUT_CALL_RATIO_OI\" not between", value1, value2, "putCallRatioOi");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database name APP.TB_PUT_CALL_RATIO
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
     * This class corresponds to the database name APP.TB_PUT_CALL_RATIO
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