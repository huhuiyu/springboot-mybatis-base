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

  TbTokenInfo queryImageCodeByToken(TbTokenInfo tokenInfo) throws Exception;

  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;
}
