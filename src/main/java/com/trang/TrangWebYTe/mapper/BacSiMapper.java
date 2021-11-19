package com.trang.TrangWebYTe.mapper;

import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.BacSiExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BacSiMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	long countByExample(BacSiExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int deleteByExample(BacSiExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int insert(BacSi record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int insertSelective(BacSi record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	List<BacSi> selectByExample(BacSiExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	BacSi selectByPrimaryKey(Integer id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByExampleSelective(@Param("record") BacSi record, @Param("example") BacSiExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByExample(@Param("record") BacSi record, @Param("example") BacSiExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByPrimaryKeySelective(BacSi record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bacsi
	 * @mbg.generated  Thu Nov 18 23:25:06 ICT 2021
	 */
	int updateByPrimaryKey(BacSi record);
	List<Map<String, Object>> getAllBacSiTenKhoa();
    List<Map<String, Object>> getAllBacSiTenKhoaTheoten(Map<String, Object> fullname);

    List<Map<String, Object>> getAllBacSiTenKhoaTheoId(Map<String, Object> ma);
}