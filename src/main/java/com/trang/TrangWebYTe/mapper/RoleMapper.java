package com.trang.TrangWebYTe.mapper;

import com.trang.TrangWebYTe.model.Role;
import com.trang.TrangWebYTe.model.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RoleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	long countByExample(RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int deleteByExample(RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int insert(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int insertSelective(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	List<Role> selectByExample(RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	Role selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByPrimaryKeySelective(Role record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByPrimaryKey(Role record);
}