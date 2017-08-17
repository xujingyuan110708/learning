package com.ms.www.model;

import java.util.Date;

public class TRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.code
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.role_name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer isDele;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.id
     *
     * @return the value of t_role.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.id
     *
     * @param id the value for t_role.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.code
     *
     * @return the value of t_role.code
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.code
     *
     * @param code the value for t_role.code
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.role_name
     *
     * @return the value of t_role.role_name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.role_name
     *
     * @param roleName the value for t_role.role_name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.create_time
     *
     * @return the value of t_role.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.create_time
     *
     * @param createTime the value for t_role.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.update_time
     *
     * @return the value of t_role.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.update_time
     *
     * @param updateTime the value for t_role.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.is_dele
     *
     * @return the value of t_role.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getIsDele() {
        return isDele;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.is_dele
     *
     * @param isDele the value for t_role.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setIsDele(Integer isDele) {
        this.isDele = isDele;
    }
}