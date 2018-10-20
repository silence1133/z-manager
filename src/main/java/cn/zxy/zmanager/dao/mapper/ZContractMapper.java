package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZContract;
import cn.zxy.zmanager.dao.dataobject.ZContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZContractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    long countByExample(ZContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int deleteByExample(ZContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int insert(ZContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int insertSelective(ZContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    List<ZContract> selectByExample(ZContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    ZContract selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZContract record, @Param("example") ZContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int updateByExample(@Param("record") ZContract record, @Param("example") ZContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int updateByPrimaryKeySelective(ZContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_contract
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    int updateByPrimaryKey(ZContract record);
}