package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZMerchant;
import cn.zxy.zmanager.dao.dataobject.ZMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZMerchantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    long countByExample(ZMerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int deleteByExample(ZMerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int insert(ZMerchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int insertSelective(ZMerchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    List<ZMerchant> selectByExample(ZMerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    ZMerchant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZMerchant record, @Param("example") ZMerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int updateByExample(@Param("record") ZMerchant record, @Param("example") ZMerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int updateByPrimaryKeySelective(ZMerchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_merchant
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    int updateByPrimaryKey(ZMerchant record);
}