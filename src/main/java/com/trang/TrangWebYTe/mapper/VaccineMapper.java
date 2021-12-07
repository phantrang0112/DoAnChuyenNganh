package com.trang.TrangWebYTe.mapper;

import com.trang.TrangWebYTe.model.Vaccine;
import com.trang.TrangWebYTe.model.VaccineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VaccineMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	long countByExample(VaccineExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int deleteByExample(VaccineExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int deleteByPrimaryKey(Integer ma);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int insert(Vaccine record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int insertSelective(Vaccine record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	List<Vaccine> selectByExample(VaccineExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	Vaccine selectByPrimaryKey(Integer ma);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int updateByExampleSelective(@Param("record") Vaccine record, @Param("example") VaccineExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int updateByExample(@Param("record") Vaccine record, @Param("example") VaccineExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int updateByPrimaryKeySelective(Vaccine record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vaccine
	 * @mbg.generated  Wed Dec 08 01:24:27 ICT 2021
	 */
	int updateByPrimaryKey(Vaccine record);
}