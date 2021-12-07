package com.trang.TrangWebYTe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ToaThuocExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public ToaThuocExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
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
			List<java.sql.Date> dateList = new ArrayList<>();
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

		public Criteria andMaIsNull() {
			addCriterion("ma is null");
			return (Criteria) this;
		}

		public Criteria andMaIsNotNull() {
			addCriterion("ma is not null");
			return (Criteria) this;
		}

		public Criteria andMaEqualTo(Integer value) {
			addCriterion("ma =", value, "ma");
			return (Criteria) this;
		}

		public Criteria andMaNotEqualTo(Integer value) {
			addCriterion("ma <>", value, "ma");
			return (Criteria) this;
		}

		public Criteria andMaGreaterThan(Integer value) {
			addCriterion("ma >", value, "ma");
			return (Criteria) this;
		}

		public Criteria andMaGreaterThanOrEqualTo(Integer value) {
			addCriterion("ma >=", value, "ma");
			return (Criteria) this;
		}

		public Criteria andMaLessThan(Integer value) {
			addCriterion("ma <", value, "ma");
			return (Criteria) this;
		}

		public Criteria andMaLessThanOrEqualTo(Integer value) {
			addCriterion("ma <=", value, "ma");
			return (Criteria) this;
		}

		public Criteria andMaIn(List<Integer> values) {
			addCriterion("ma in", values, "ma");
			return (Criteria) this;
		}

		public Criteria andMaNotIn(List<Integer> values) {
			addCriterion("ma not in", values, "ma");
			return (Criteria) this;
		}

		public Criteria andMaBetween(Integer value1, Integer value2) {
			addCriterion("ma between", value1, value2, "ma");
			return (Criteria) this;
		}

		public Criteria andMaNotBetween(Integer value1, Integer value2) {
			addCriterion("ma not between", value1, value2, "ma");
			return (Criteria) this;
		}

		public Criteria andNgaytaoIsNull() {
			addCriterion("ngaytao is null");
			return (Criteria) this;
		}

		public Criteria andNgaytaoIsNotNull() {
			addCriterion("ngaytao is not null");
			return (Criteria) this;
		}

		public Criteria andNgaytaoEqualTo(Date value) {
			addCriterionForJDBCDate("ngaytao =", value, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoNotEqualTo(Date value) {
			addCriterionForJDBCDate("ngaytao <>", value, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoGreaterThan(Date value) {
			addCriterionForJDBCDate("ngaytao >", value, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ngaytao >=", value, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoLessThan(Date value) {
			addCriterionForJDBCDate("ngaytao <", value, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ngaytao <=", value, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoIn(List<Date> values) {
			addCriterionForJDBCDate("ngaytao in", values, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoNotIn(List<Date> values) {
			addCriterionForJDBCDate("ngaytao not in", values, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ngaytao between", value1, value2, "ngaytao");
			return (Criteria) this;
		}

		public Criteria andNgaytaoNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ngaytao not between", value1, value2, "ngaytao");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table toathuoc
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
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
     * This class corresponds to the database table toathuoc
     *
     * @mbg.generated do_not_delete_during_merge Sat Nov 27 16:00:09 ICT 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}