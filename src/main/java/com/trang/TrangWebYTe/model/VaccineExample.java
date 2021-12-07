package com.trang.TrangWebYTe.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VaccineExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public VaccineExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table vaccine
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

		public Criteria andTenvaccineIsNull() {
			addCriterion("tenvaccine is null");
			return (Criteria) this;
		}

		public Criteria andTenvaccineIsNotNull() {
			addCriterion("tenvaccine is not null");
			return (Criteria) this;
		}

		public Criteria andTenvaccineEqualTo(String value) {
			addCriterion("tenvaccine =", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineNotEqualTo(String value) {
			addCriterion("tenvaccine <>", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineGreaterThan(String value) {
			addCriterion("tenvaccine >", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineGreaterThanOrEqualTo(String value) {
			addCriterion("tenvaccine >=", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineLessThan(String value) {
			addCriterion("tenvaccine <", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineLessThanOrEqualTo(String value) {
			addCriterion("tenvaccine <=", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineLike(String value) {
			addCriterion("tenvaccine like", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineNotLike(String value) {
			addCriterion("tenvaccine not like", value, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineIn(List<String> values) {
			addCriterion("tenvaccine in", values, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineNotIn(List<String> values) {
			addCriterion("tenvaccine not in", values, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineBetween(String value1, String value2) {
			addCriterion("tenvaccine between", value1, value2, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTenvaccineNotBetween(String value1, String value2) {
			addCriterion("tenvaccine not between", value1, value2, "tenvaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineIsNull() {
			addCriterion("trangthaivaccine is null");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineIsNotNull() {
			addCriterion("trangthaivaccine is not null");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineEqualTo(String value) {
			addCriterion("trangthaivaccine =", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineNotEqualTo(String value) {
			addCriterion("trangthaivaccine <>", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineGreaterThan(String value) {
			addCriterion("trangthaivaccine >", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineGreaterThanOrEqualTo(String value) {
			addCriterion("trangthaivaccine >=", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineLessThan(String value) {
			addCriterion("trangthaivaccine <", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineLessThanOrEqualTo(String value) {
			addCriterion("trangthaivaccine <=", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineLike(String value) {
			addCriterion("trangthaivaccine like", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineNotLike(String value) {
			addCriterion("trangthaivaccine not like", value, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineIn(List<String> values) {
			addCriterion("trangthaivaccine in", values, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineNotIn(List<String> values) {
			addCriterion("trangthaivaccine not in", values, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineBetween(String value1, String value2) {
			addCriterion("trangthaivaccine between", value1, value2, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andTrangthaivaccineNotBetween(String value1, String value2) {
			addCriterion("trangthaivaccine not between", value1, value2, "trangthaivaccine");
			return (Criteria) this;
		}

		public Criteria andNgaynhapIsNull() {
			addCriterion("ngaynhap is null");
			return (Criteria) this;
		}

		public Criteria andNgaynhapIsNotNull() {
			addCriterion("ngaynhap is not null");
			return (Criteria) this;
		}

		public Criteria andNgaynhapEqualTo(Date value) {
			addCriterionForJDBCDate("ngaynhap =", value, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapNotEqualTo(Date value) {
			addCriterionForJDBCDate("ngaynhap <>", value, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapGreaterThan(Date value) {
			addCriterionForJDBCDate("ngaynhap >", value, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ngaynhap >=", value, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapLessThan(Date value) {
			addCriterionForJDBCDate("ngaynhap <", value, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ngaynhap <=", value, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapIn(List<Date> values) {
			addCriterionForJDBCDate("ngaynhap in", values, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapNotIn(List<Date> values) {
			addCriterionForJDBCDate("ngaynhap not in", values, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ngaynhap between", value1, value2, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andNgaynhapNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ngaynhap not between", value1, value2, "ngaynhap");
			return (Criteria) this;
		}

		public Criteria andHansudungIsNull() {
			addCriterion("hansudung is null");
			return (Criteria) this;
		}

		public Criteria andHansudungIsNotNull() {
			addCriterion("hansudung is not null");
			return (Criteria) this;
		}

		public Criteria andHansudungEqualTo(Date value) {
			addCriterionForJDBCDate("hansudung =", value, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungNotEqualTo(Date value) {
			addCriterionForJDBCDate("hansudung <>", value, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungGreaterThan(Date value) {
			addCriterionForJDBCDate("hansudung >", value, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("hansudung >=", value, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungLessThan(Date value) {
			addCriterionForJDBCDate("hansudung <", value, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("hansudung <=", value, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungIn(List<Date> values) {
			addCriterionForJDBCDate("hansudung in", values, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungNotIn(List<Date> values) {
			addCriterionForJDBCDate("hansudung not in", values, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("hansudung between", value1, value2, "hansudung");
			return (Criteria) this;
		}

		public Criteria andHansudungNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("hansudung not between", value1, value2, "hansudung");
			return (Criteria) this;
		}

		public Criteria andSoluongIsNull() {
			addCriterion("soluong is null");
			return (Criteria) this;
		}

		public Criteria andSoluongIsNotNull() {
			addCriterion("soluong is not null");
			return (Criteria) this;
		}

		public Criteria andSoluongEqualTo(Integer value) {
			addCriterion("soluong =", value, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongNotEqualTo(Integer value) {
			addCriterion("soluong <>", value, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongGreaterThan(Integer value) {
			addCriterion("soluong >", value, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongGreaterThanOrEqualTo(Integer value) {
			addCriterion("soluong >=", value, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongLessThan(Integer value) {
			addCriterion("soluong <", value, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongLessThanOrEqualTo(Integer value) {
			addCriterion("soluong <=", value, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongIn(List<Integer> values) {
			addCriterion("soluong in", values, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongNotIn(List<Integer> values) {
			addCriterion("soluong not in", values, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongBetween(Integer value1, Integer value2) {
			addCriterion("soluong between", value1, value2, "soluong");
			return (Criteria) this;
		}

		public Criteria andSoluongNotBetween(Integer value1, Integer value2) {
			addCriterion("soluong not between", value1, value2, "soluong");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table vaccine
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
     * This class corresponds to the database table vaccine
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 22 08:58:17 ICT 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}