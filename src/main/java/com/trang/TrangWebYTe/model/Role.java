package com.trang.TrangWebYTe.model;

public class Role {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.id
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.tenquyen
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	private String tenquyen;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.id
	 * @return  the value of role.id
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.id
	 * @param id  the value for role.id
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.tenquyen
	 * @return  the value of role.tenquyen
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public String getTenquyen() {
		return tenquyen;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.tenquyen
	 * @param tenquyen  the value for role.tenquyen
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}
}