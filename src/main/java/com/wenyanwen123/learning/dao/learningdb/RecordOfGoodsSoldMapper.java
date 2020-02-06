package com.wenyanwen123.learning.dao.learningdb;

import com.wenyanwen123.learning.commons.domain.learningdb.RecordOfGoodsSold;
import com.wenyanwen123.learning.commons.domain.learningdb.RecordOfGoodsSoldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordOfGoodsSoldMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    long countByExample(RecordOfGoodsSoldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int deleteByExample(RecordOfGoodsSoldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int deleteByPrimaryKey(Integer recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int insert(RecordOfGoodsSold record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int insertSelective(RecordOfGoodsSold record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    List<RecordOfGoodsSold> selectByExample(RecordOfGoodsSoldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    RecordOfGoodsSold selectByPrimaryKey(Integer recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") RecordOfGoodsSold record, @Param("example") RecordOfGoodsSoldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int updateByExample(@Param("record") RecordOfGoodsSold record, @Param("example") RecordOfGoodsSoldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int updateByPrimaryKeySelective(RecordOfGoodsSold record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_record_of_goods_sold
     *
     * @mbg.generated Thu Feb 06 16:14:58 CST 2020
     */
    int updateByPrimaryKey(RecordOfGoodsSold record);
}