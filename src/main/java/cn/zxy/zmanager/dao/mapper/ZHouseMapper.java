package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZHouse;
import cn.zxy.zmanager.dao.dataobject.ZHouseExample;
import cn.zxy.zmanager.support.LoginUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZHouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    long countByExample(ZHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int deleteByExample(ZHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int insert(ZHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int insertSelective(ZHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    List<ZHouse> selectByExample(ZHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    ZHouse selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZHouse record, @Param("example") ZHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int updateByExample(@Param("record") ZHouse record, @Param("example") ZHouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int updateByPrimaryKeySelective(ZHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_house
     *
     * @mbg.generated Mon Oct 08 23:26:36 CST 2018
     */
    int updateByPrimaryKey(ZHouse record);

	List<ZHouse> selectByPrimaryKeies(@Param("list") List<Integer> houseIdList);

	int updateStatusByIdList(@Param("list") List<Integer> houseIdList, @Param("status") Integer alreadyRented);

	int updateHouseListStatus(@Param("list") List<ZHouse> houseList, @Param("user") LoginUser loginUser);

}