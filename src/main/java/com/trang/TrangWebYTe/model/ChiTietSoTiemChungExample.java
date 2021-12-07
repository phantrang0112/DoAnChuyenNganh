package com.trang.TrangWebYTe.model;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSoTiemChungExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public ChiTietSoTiemChungExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
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

		public Criteria andMasotiemchungIsNull() {
			addCriterion("masotiemchung is null");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungIsNotNull() {
			addCriterion("masotiemchung is not null");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungEqualTo(Integer value) {
			addCriterion("masotiemchung =", value, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungNotEqualTo(Integer value) {
			addCriterion("masotiemchung <>", value, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungGreaterThan(Integer value) {
			addCriterion("masotiemchung >", value, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungGreaterThanOrEqualTo(Integer value) {
			addCriterion("masotiemchung >=", value, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungLessThan(Integer value) {
			addCriterion("masotiemchung <", value, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungLessThanOrEqualTo(Integer value) {
			addCriterion("masotiemchung <=", value, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungIn(List<Integer> values) {
			addCriterion("masotiemchung in", values, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungNotIn(List<Integer> values) {
			addCriterion("masotiemchung not in", values, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungBetween(Integer value1, Integer value2) {
			addCriterion("masotiemchung between", value1, value2, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMasotiemchungNotBetween(Integer value1, Integer value2) {
			addCriterion("masotiemchung not between", value1, value2, "masotiemchung");
			return (Criteria) this;
		}

		public Criteria andMavaccineIsNull() {
			addCriterion("mavaccine is null");
			return (Criteria) this;
		}

		public Criteria andMavaccineIsNotNull() {
			addCriterion("mavaccine is not null");
			return (Criteria) this;
		}

		public Criteria andMavaccineEqualTo(Integer value) {
			addCriterion("mavaccine =", value, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineNotEqualTo(Integer value) {
			addCriterion("mavaccine <>", value, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineGreaterThan(Integer value) {
			addCriterion("mavaccine >", value, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineGreaterThanOrEqualTo(Integer value) {
			addCriterion("mavaccine >=", value, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineLessThan(Integer value) {
			addCriterion("mavaccine <", value, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineLessThanOrEqualTo(Integer value) {
			addCriterion("mavaccine <=", value, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineIn(List<Integer> values) {
			addCriterion("mavaccine in", values, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineNotIn(List<Integer> values) {
			addCriterion("mavaccine not in", values, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineBetween(Integer value1, Integer value2) {
			addCriterion("mavaccine between", value1, value2, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andMavaccineNotBetween(Integer value1, Integer value2) {
			addCriterion("mavaccine not between", value1, value2, "mavaccine");
			return (Criteria) this;
		}

		public Criteria andSolieuIsNull() {
			addCriterion("solieu is null");
			return (Criteria) this;
		}

		public Criteria andSolieuIsNotNull() {
			addCriterion("solieu is not null");
			return (Criteria) this;
		}

		public Criteria andSolieuEqualTo(Integer value) {
			addCriterion("solieu =", value, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuNotEqualTo(Integer value) {
			addCriterion("solieu <>", value, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuGreaterThan(Integer value) {
			addCriterion("solieu >", value, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuGreaterThanOrEqualTo(Integer value) {
			addCriterion("solieu >=", value, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuLessThan(Integer value) {
			addCriterion("solieu <", value, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuLessThanOrEqualTo(Integer value) {
			addCriterion("solieu <=", value, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuIn(List<Integer> values) {
			addCriterion("solieu in", values, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuNotIn(List<Integer> values) {
			addCriterion("solieu not in", values, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuBetween(Integer value1, Integer value2) {
			addCriterion("solieu between", value1, value2, "solieu");
			return (Criteria) this;
		}

		public Criteria andSolieuNotBetween(Integer value1, Integer value2) {
			addCriterion("solieu not between", value1, value2, "solieu");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemIsNull() {
			addCriterion("trieuchungsautiem is null");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemIsNotNull() {
			addCriterion("trieuchungsautiem is not null");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemEqualTo(String value) {
			addCriterion("trieuchungsautiem =", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemNotEqualTo(String value) {
			addCriterion("trieuchungsautiem <>", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemGreaterThan(String value) {
			addCriterion("trieuchungsautiem >", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemGreaterThanOrEqualTo(String value) {
			addCriterion("trieuchungsautiem >=", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemLessThan(String value) {
			addCriterion("trieuchungsautiem <", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemLessThanOrEqualTo(String value) {
			addCriterion("trieuchungsautiem <=", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemLike(String value) {
			addCriterion("trieuchungsautiem like", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemNotLike(String value) {
			addCriterion("trieuchungsautiem not like", value, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemIn(List<String> values) {
			addCriterion("trieuchungsautiem in", values, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemNotIn(List<String> values) {
			addCriterion("trieuchungsautiem not in", values, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemBetween(String value1, String value2) {
			addCriterion("trieuchungsautiem between", value1, value2, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrieuchungsautiemNotBetween(String value1, String value2) {
			addCriterion("trieuchungsautiem not between", value1, value2, "trieuchungsautiem");
			return (Criteria) this;
		}

		public Criteria andTrangthaiIsNull() {
			addCriterion("trangthai is null");
			return (Criteria) this;
		}

		public Criteria andTrangthaiIsNotNull() {
			addCriterion("trangthai is not null");
			return (Criteria) this;
		}

		public Criteria andTrangthaiEqualTo(String value) {
			addCriterion("trangthai =", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiNotEqualTo(String value) {
			addCriterion("trangthai <>", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiGreaterThan(String value) {
			addCriterion("trangthai >", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiGreaterThanOrEqualTo(String value) {
			addCriterion("trangthai >=", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiLessThan(String value) {
			addCriterion("trangthai <", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiLessThanOrEqualTo(String value) {
			addCriterion("trangthai <=", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiLike(String value) {
			addCriterion("trangthai like", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiNotLike(String value) {
			addCriterion("trangthai not like", value, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiIn(List<String> values) {
			addCriterion("trangthai in", values, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiNotIn(List<String> values) {
			addCriterion("trangthai not in", values, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiBetween(String value1, String value2) {
			addCriterion("trangthai between", value1, value2, "trangthai");
			return (Criteria) this;
		}

		public Criteria andTrangthaiNotBetween(String value1, String value2) {
			addCriterion("trangthai not between", value1, value2, "trangthai");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table chitietsotiemchung
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 22 08:58:17 ICT 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}