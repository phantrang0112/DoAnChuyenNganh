package com.trang.TrangWebYTe.model;

import java.util.Date;

public class SoTiemChung {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sotiemchung.ma
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	private Integer ma;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sotiemchung.userId
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	private Integer userid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sotiemchung.ngaytiem
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	private Date ngaytiem;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sotiemchung.ma
	 * @return  the value of sotiemchung.ma
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	public Integer getMa() {
		return ma;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sotiemchung.ma
	 * @param ma  the value for sotiemchung.ma
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	public void setMa(Integer ma) {
		this.ma = ma;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sotiemchung.userId
	 * @return  the value of sotiemchung.userId
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sotiemchung.userId
	 * @param userid  the value for sotiemchung.userId
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sotiemchung.ngaytiem
	 * @return  the value of sotiemchung.ngaytiem
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	public Date getNgaytiem() {
		return ngaytiem;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sotiemchung.ngaytiem
	 * @param ngaytiem  the value for sotiemchung.ngaytiem
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	public void setNgaytiem(Date ngaytiem) {
		this.ngaytiem = ngaytiem;
	}
}