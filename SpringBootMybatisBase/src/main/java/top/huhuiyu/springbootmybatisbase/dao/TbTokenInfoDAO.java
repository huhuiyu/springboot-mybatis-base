package top.huhuiyu.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;

/**
 * TbTokenInfo表的dao
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenInfoDAO {

  /**
   * -查询图片校验码是否存在
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryImageCodeByToken(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;
}
