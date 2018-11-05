package cn.zxy.zmanager.dao.dataobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZMaterialType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.name
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.create_emp
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    private String createEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.create_emp_id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    private Integer createEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.create_time
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.modify_emp
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    private String modifyEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.modify_emp_id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    private Integer modifyEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_material_type.modify_time
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.id
     *
     * @return the value of z_material_type.id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.id
     *
     * @param id the value for z_material_type.id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.name
     *
     * @return the value of z_material_type.name
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.name
     *
     * @param name the value for z_material_type.name
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.create_emp
     *
     * @return the value of z_material_type.create_emp
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public String getCreateEmp() {
        return createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.create_emp
     *
     * @param createEmp the value for z_material_type.create_emp
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.create_emp_id
     *
     * @return the value of z_material_type.create_emp_id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public Integer getCreateEmpId() {
        return createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.create_emp_id
     *
     * @param createEmpId the value for z_material_type.create_emp_id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setCreateEmpId(Integer createEmpId) {
        this.createEmpId = createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.create_time
     *
     * @return the value of z_material_type.create_time
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.create_time
     *
     * @param createTime the value for z_material_type.create_time
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.modify_emp
     *
     * @return the value of z_material_type.modify_emp
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public String getModifyEmp() {
        return modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.modify_emp
     *
     * @param modifyEmp the value for z_material_type.modify_emp
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setModifyEmp(String modifyEmp) {
        this.modifyEmp = modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.modify_emp_id
     *
     * @return the value of z_material_type.modify_emp_id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public Integer getModifyEmpId() {
        return modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.modify_emp_id
     *
     * @param modifyEmpId the value for z_material_type.modify_emp_id
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setModifyEmpId(Integer modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_material_type.modify_time
     *
     * @return the value of z_material_type.modify_time
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_material_type.modify_time
     *
     * @param modifyTime the value for z_material_type.modify_time
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}