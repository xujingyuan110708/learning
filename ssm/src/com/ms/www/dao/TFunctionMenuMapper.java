package com.ms.www.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ms.www.model.TFunctionMenu;

public interface TFunctionMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_function_menu
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_function_menu
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    int insert(TFunctionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_function_menu
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    int insertSelective(TFunctionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_function_menu
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    TFunctionMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_function_menu
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    int updateByPrimaryKeySelective(TFunctionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_function_menu
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    int updateByPrimaryKey(TFunctionMenu record);
    
    public List<TFunctionMenu> getMenuByUserId(@Param("userId")Integer userId,@Param("pId")Integer pId);
    
    
    public List<TFunctionMenu> getMenuByPId(@Param("pId")Integer pId);
}