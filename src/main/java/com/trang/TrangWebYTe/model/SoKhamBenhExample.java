package com.trang.TrangWebYTe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SoKhamBenhExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public SoKhamBenhExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Sat Dec 04 10:24:43 ICT 2021
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sokhambenh
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

		public Criteria andMasokhambenhIsNull() {
			addCriterion("masokhambenh is null");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhIsNotNull() {
			addCriterion("masokhambenh is not null");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhEqualTo(Integer value) {
			addCriterion("masokhambenh =", value, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhNotEqualTo(Integer value) {
			addCriterion("masokhambenh <>", value, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhGreaterThan(Integer value) {
			addCriterion("masokhambenh >", value, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhGreaterThanOrEqualTo(Integer value) {
			addCriterion("masokhambenh >=", value, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhLessThan(Integer value) {
			addCriterion("masokhambenh <", value, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhLessThanOrEqualTo(Integer value) {
			addCriterion("masokhambenh <=", value, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhIn(List<Integer> values) {
			addCriterion("masokhambenh in", values, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhNotIn(List<Integer> values) {
			addCriterion("masokhambenh not in", values, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhBetween(Integer value1, Integer value2) {
			addCriterion("masokhambenh between", value1, value2, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andMasokhambenhNotBetween(Integer value1, Integer value2) {
			addCriterion("masokhambenh not between", value1, value2, "masokhambenh");
			return (Criteria) this;
		}

		public Criteria andNgaykhamIsNull() {
			addCriterion("ngaykham is null");
			return (Criteria) this;
		}

		public Criteria andNgaykhamIsNotNull() {
			addCriterion("ngaykham is not null");
			return (Criteria) this;
		}

		public Criteria andNgaykhamEqualTo(Date value) {
			addCriterionForJDBCDate("ngaykham =", value, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamNotEqualTo(Date value) {
			addCriterionForJDBCDate("ngaykham <>", value, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamGreaterThan(Date value) {
			addCriterionForJDBCDate("ngaykham >", value, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ngaykham >=", value, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamLessThan(Date value) {
			addCriterionForJDBCDate("ngaykham <", value, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ngaykham <=", value, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamIn(List<Date> values) {
			addCriterionForJDBCDate("ngaykham in", values, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamNotIn(List<Date> values) {
			addCriterionForJDBCDate("ngaykham not in", values, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ngaykham between", value1, value2, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andNgaykhamNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ngaykham not between", value1, value2, "ngaykham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamIsNull() {
			addCriterion("malichkham is null");
			return (Criteria) this;
		}

		public Criteria andMalichkhamIsNotNull() {
			addCriterion("malichkham is not null");
			return (Criteria) this;
		}

		public Criteria andMalichkhamEqualTo(Integer value) {
			addCriterion("malichkham =", value, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamNotEqualTo(Integer value) {
			addCriterion("malichkham <>", value, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamGreaterThan(Integer value) {
			addCriterion("malichkham >", value, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamGreaterThanOrEqualTo(Integer value) {
			addCriterion("malichkham >=", value, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamLessThan(Integer value) {
			addCriterion("malichkham <", value, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamLessThanOrEqualTo(Integer value) {
			addCriterion("malichkham <=", value, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamIn(List<Integer> values) {
			addCriterion("malichkham in", values, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamNotIn(List<Integer> values) {
			addCriterion("malichkham not in", values, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamBetween(Integer value1, Integer value2) {
			addCriterion("malichkham between", value1, value2, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMalichkhamNotBetween(Integer value1, Integer value2) {
			addCriterion("malichkham not between", value1, value2, "malichkham");
			return (Criteria) this;
		}

		public Criteria andMatoathuocIsNull() {
			addCriterion("matoathuoc is null");
			return (Criteria) this;
		}

		public Criteria andMatoathuocIsNotNull() {
			addCriterion("matoathuoc is not null");
			return (Criteria) this;
		}

		public Criteria andMatoathuocEqualTo(Integer value) {
			addCriterion("matoathuoc =", value, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocNotEqualTo(Integer value) {
			addCriterion("matoathuoc <>", value, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocGreaterThan(Integer value) {
			addCriterion("matoathuoc >", value, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocGreaterThanOrEqualTo(Integer value) {
			addCriterion("matoathuoc >=", value, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocLessThan(Integer value) {
			addCriterion("matoathuoc <", value, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocLessThanOrEqualTo(Integer value) {
			addCriterion("matoathuoc <=", value, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocIn(List<Integer> values) {
			addCriterion("matoathuoc in", values, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocNotIn(List<Integer> values) {
			addCriterion("matoathuoc not in", values, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocBetween(Integer value1, Integer value2) {
			addCriterion("matoathuoc between", value1, value2, "matoathuoc");
			return (Criteria) this;
		}

		public Criteria andMatoathuocNotBetween(Integer value1, Integer value2) {
			addCriterion("matoathuoc not between", value1, value2, "matoathuoc");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sokhambenh
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
     * This class corresponds to the database table sokhambenh
     *
     * @mbg.generated do_not_delete_during_merge Thu Nov 25 23:13:47 ICT 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}