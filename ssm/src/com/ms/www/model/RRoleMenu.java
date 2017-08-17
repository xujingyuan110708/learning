package com.ms.www.model;

import java.util.Date;

public class RRoleMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.fk_role_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer fkRoleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.fk_menu_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer fkMenuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.total_root_code
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer totalRootCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_role_menu.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer isDele;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.id
     *
     * @return the value of r_role_menu.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.id
     *
     * @param id the value for r_role_menu.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.fk_role_id
     *
     * @return the value of r_role_menu.fk_role_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getFkRoleId() {
        return fkRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.fk_role_id
     *
     * @param fkRoleId the value for r_role_menu.fk_role_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setFkRoleId(Integer fkRoleId) {
        this.fkRoleId = fkRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.fk_menu_id
     *
     * @return the value of r_role_menu.fk_menu_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getFkMenuId() {
        return fkMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.fk_menu_id
     *
     * @param fkMenuId the value for r_role_menu.fk_menu_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setFkMenuId(Integer fkMenuId) {
        this.fkMenuId = fkMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.total_root_code
     *
     * @return the value of r_role_menu.total_root_code
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getTotalRootCode() {
        return totalRootCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.total_root_code
     *
     * @param totalRootCode the value for r_role_menu.total_root_code
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setTotalRootCode(Integer totalRootCode) {
        this.totalRootCode = totalRootCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.create_time
     *
     * @return the value of r_role_menu.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.create_time
     *
     * @param createTime the value for r_role_menu.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.update_time
     *
     * @return the value of r_role_menu.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.update_time
     *
     * @param updateTime the value for r_role_menu.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_role_menu.is_dele
     *
     * @return the value of r_role_menu.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getIsDele() {
        return isDele;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_role_menu.is_dele
     *
     * @param isDele the value for r_role_menu.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setIsDele(Integer isDele) {
        this.isDele = isDele;
    }
}