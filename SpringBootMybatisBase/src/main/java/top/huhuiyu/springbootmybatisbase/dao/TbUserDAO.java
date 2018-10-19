package top.huhuiyu.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springbootmybatisbase.entity.TbUser;

/**
 * TbUser-数据访问类
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbUserDAO {
  /**
   * login-用户登录信息校验
   * 
   * @param user 登录用户信息
   * @return 正确就返回用户完整信息，否则返回null
   * @throws Exception
   */
  TbUser login(TbUser user) throws Exception;
}
