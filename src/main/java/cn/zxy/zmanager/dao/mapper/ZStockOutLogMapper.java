package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZStockOutLog;
import cn.zxy.zmanager.dao.dataobject.ZStockOutLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZStockOutLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    long countByExample(ZStockOutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int deleteByExample(ZStockOutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int insert(ZStockOutLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int insertSelective(ZStockOutLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    List<ZStockOutLog> selectByExample(ZStockOutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    ZStockOutLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZStockOutLog record, @Param("example") ZStockOutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int updateByExample(@Param("record") ZStockOutLog record, @Param("example") ZStockOutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int updateByPrimaryKeySelective(ZStockOutLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_stock_out_log
     *
     * @mbg.generated Sun Oct 28 19:21:08 CST 2018
     */
    int updateByPrimaryKey(ZStockOutLog record);
}