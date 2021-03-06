package cn.zxy.zmanager.dao.dataobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZHouseFee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.contract_house_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer contractHouseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.contract_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.contract_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private String contractCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.house_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer houseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.house_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private String houseCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.merchant_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer merchantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.merchant_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private String merchantCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.company
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.corporate_body
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private String corporateBody;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer rentFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer propertyFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.area
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Double area;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.sort
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.total_rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer totalRentFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.total_property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer totalPropertyFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.rent_month
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer rentMonth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.property_month
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer propertyMonth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.pay_deadline
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payDeadline;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.remarks
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.paid_rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer paidRentFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.paid_property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    private Integer paidPropertyFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_house_fee.create_time
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.id
     *
     * @return the value of z_house_fee.id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.id
     *
     * @param id the value for z_house_fee.id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.contract_house_id
     *
     * @return the value of z_house_fee.contract_house_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getContractHouseId() {
        return contractHouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.contract_house_id
     *
     * @param contractHouseId the value for z_house_fee.contract_house_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setContractHouseId(Integer contractHouseId) {
        this.contractHouseId = contractHouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.contract_id
     *
     * @return the value of z_house_fee.contract_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.contract_id
     *
     * @param contractId the value for z_house_fee.contract_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.contract_code
     *
     * @return the value of z_house_fee.contract_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.contract_code
     *
     * @param contractCode the value for z_house_fee.contract_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.house_id
     *
     * @return the value of z_house_fee.house_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.house_id
     *
     * @param houseId the value for z_house_fee.house_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.house_code
     *
     * @return the value of z_house_fee.house_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public String getHouseCode() {
        return houseCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.house_code
     *
     * @param houseCode the value for z_house_fee.house_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.merchant_id
     *
     * @return the value of z_house_fee.merchant_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.merchant_id
     *
     * @param merchantId the value for z_house_fee.merchant_id
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.merchant_code
     *
     * @return the value of z_house_fee.merchant_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.merchant_code
     *
     * @param merchantCode the value for z_house_fee.merchant_code
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.company
     *
     * @return the value of z_house_fee.company
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.company
     *
     * @param company the value for z_house_fee.company
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.corporate_body
     *
     * @return the value of z_house_fee.corporate_body
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public String getCorporateBody() {
        return corporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.corporate_body
     *
     * @param corporateBody the value for z_house_fee.corporate_body
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setCorporateBody(String corporateBody) {
        this.corporateBody = corporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.rent_fee
     *
     * @return the value of z_house_fee.rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getRentFee() {
        return rentFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.rent_fee
     *
     * @param rentFee the value for z_house_fee.rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setRentFee(Integer rentFee) {
        this.rentFee = rentFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.property_fee
     *
     * @return the value of z_house_fee.property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getPropertyFee() {
        return propertyFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.property_fee
     *
     * @param propertyFee the value for z_house_fee.property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setPropertyFee(Integer propertyFee) {
        this.propertyFee = propertyFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.area
     *
     * @return the value of z_house_fee.area
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Double getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.area
     *
     * @param area the value for z_house_fee.area
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.sort
     *
     * @return the value of z_house_fee.sort
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.sort
     *
     * @param sort the value for z_house_fee.sort
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.total_rent_fee
     *
     * @return the value of z_house_fee.total_rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getTotalRentFee() {
        return totalRentFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.total_rent_fee
     *
     * @param totalRentFee the value for z_house_fee.total_rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setTotalRentFee(Integer totalRentFee) {
        this.totalRentFee = totalRentFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.total_property_fee
     *
     * @return the value of z_house_fee.total_property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getTotalPropertyFee() {
        return totalPropertyFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.total_property_fee
     *
     * @param totalPropertyFee the value for z_house_fee.total_property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setTotalPropertyFee(Integer totalPropertyFee) {
        this.totalPropertyFee = totalPropertyFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.rent_month
     *
     * @return the value of z_house_fee.rent_month
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getRentMonth() {
        return rentMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.rent_month
     *
     * @param rentMonth the value for z_house_fee.rent_month
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setRentMonth(Integer rentMonth) {
        this.rentMonth = rentMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.property_month
     *
     * @return the value of z_house_fee.property_month
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getPropertyMonth() {
        return propertyMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.property_month
     *
     * @param propertyMonth the value for z_house_fee.property_month
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setPropertyMonth(Integer propertyMonth) {
        this.propertyMonth = propertyMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.pay_deadline
     *
     * @return the value of z_house_fee.pay_deadline
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Date getPayDeadline() {
        return payDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.pay_deadline
     *
     * @param payDeadline the value for z_house_fee.pay_deadline
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setPayDeadline(Date payDeadline) {
        this.payDeadline = payDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.remarks
     *
     * @return the value of z_house_fee.remarks
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.remarks
     *
     * @param remarks the value for z_house_fee.remarks
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.paid_rent_fee
     *
     * @return the value of z_house_fee.paid_rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getPaidRentFee() {
        return paidRentFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.paid_rent_fee
     *
     * @param paidRentFee the value for z_house_fee.paid_rent_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setPaidRentFee(Integer paidRentFee) {
        this.paidRentFee = paidRentFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.paid_property_fee
     *
     * @return the value of z_house_fee.paid_property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Integer getPaidPropertyFee() {
        return paidPropertyFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.paid_property_fee
     *
     * @param paidPropertyFee the value for z_house_fee.paid_property_fee
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setPaidPropertyFee(Integer paidPropertyFee) {
        this.paidPropertyFee = paidPropertyFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_house_fee.create_time
     *
     * @return the value of z_house_fee.create_time
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_house_fee.create_time
     *
     * @param createTime the value for z_house_fee.create_time
     *
     * @mbg.generated Mon Oct 15 20:23:39 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}