package com.trang.TrangWebYTe.mapper;

import com.trang.TrangWebYTe.model.SoKhamBenh;
import com.trang.TrangWebYTe.model.SoKhamBenhExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface SoKhamBenhMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	long countByExample(SoKhamBenhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int deleteByExample(SoKhamBenhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int deleteByPrimaryKey(Integer masokhambenh);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int insert(SoKhamBenh record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int insertSelective(SoKhamBenh record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	List<SoKhamBenh> selectByExample(SoKhamBenhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	SoKhamBenh selectByPrimaryKey(Integer masokhambenh);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int updateByExampleSelective(@Param("record") SoKhamBenh record, @Param("example") SoKhamBenhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int updateByExample(@Param("record") SoKhamBenh record, @Param("example") SoKhamBenhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int updateByPrimaryKeySelective(SoKhamBenh record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sokhambenh
	 * @mbg.generated  Fri Dec 10 23:35:58 ICT 2021
	 */
	int updateByPrimaryKey(SoKhamBenh record);

	List<Map<String, Object>> getAllSoKhamBenh(Map<String, Object> object);
	
	int updateToaThuoc(SoKhamBenh record);
}