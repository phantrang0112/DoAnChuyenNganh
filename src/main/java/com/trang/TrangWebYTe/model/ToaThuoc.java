package com.trang.TrangWebYTe.model;

import java.util.Date;

public class ToaThuoc {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column toathuoc.ma
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	private Integer ma;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column toathuoc.ngaytao
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	private Date ngaytao;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column toathuoc.ma
	 * @return  the value of toathuoc.ma
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public Integer getMa() {
		return ma;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column toathuoc.ma
	 * @param ma  the value for toathuoc.ma
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public void setMa(Integer ma) {
		this.ma = ma;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column toathuoc.ngaytao
	 * @return  the value of toathuoc.ngaytao
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public Date getNgaytao() {
		return ngaytao;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column toathuoc.ngaytao
	 * @param ngaytao  the value for toathuoc.ngaytao
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
}