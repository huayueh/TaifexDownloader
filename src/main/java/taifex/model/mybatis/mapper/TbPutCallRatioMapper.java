package taifex.model.mybatis.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import taifex.model.entity.TbPutCallRatio;
import taifex.model.entity.TbPutCallRatioExample;

public interface TbPutCallRatioMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int countByExample(TbPutCallRatioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int deleteByExample(TbPutCallRatioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int deleteByPrimaryKey(Date date);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int insert(TbPutCallRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int insertSelective(TbPutCallRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    List<TbPutCallRatio> selectByExample(TbPutCallRatioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    TbPutCallRatio selectByPrimaryKey(Date date);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByExampleSelective(@Param("record") TbPutCallRatio record, @Param("example") TbPutCallRatioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByExample(@Param("record") TbPutCallRatio record, @Param("example") TbPutCallRatioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByPrimaryKeySelective(TbPutCallRatio record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database name APP.TB_PUT_CALL_RATIO
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByPrimaryKey(TbPutCallRatio record);
}