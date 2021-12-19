package com.trang.TrangWebYTe.mapper;

import com.trang.TrangWebYTe.model.ChiTietSoTiemChung;
import com.trang.TrangWebYTe.model.ChiTietSoTiemChungExample;
import com.trang.TrangWebYTe.model.ChiTietSoTiemChungKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChiTietSoTiemChungMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	long countByExample(ChiTietSoTiemChungExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int deleteByExample(ChiTietSoTiemChungExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int deleteByPrimaryKey(ChiTietSoTiemChungKey key);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int insert(ChiTietSoTiemChung record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int insertSelective(ChiTietSoTiemChung record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	List<ChiTietSoTiemChung> selectByExample(ChiTietSoTiemChungExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	ChiTietSoTiemChung selectByPrimaryKey(ChiTietSoTiemChungKey key);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int updateByExampleSelective(@Param("record") ChiTietSoTiemChung record,
			@Param("example") ChiTietSoTiemChungExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int updateByExample(@Param("record") ChiTietSoTiemChung record,
			@Param("example") ChiTietSoTiemChungExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int updateByPrimaryKeySelective(ChiTietSoTiemChung record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table chitietsotiemchung
	 * @mbg.generated  Sun Dec 19 00:24:21 ICT 2021
	 */
	int updateByPrimaryKey(ChiTietSoTiemChung record);
	List<Map<String, Object>>getAllchitietSoTiemChung(Map<String,Object> tenuser);
	List<Map<String, Object>>getAllVaccineTheoten(Map<String,Object> tenvaccine);
}