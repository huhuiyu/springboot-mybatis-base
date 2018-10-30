package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.model.UserModel;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -用户服务
 * 
 * @author DarkKnight
 *
 */
public interface UserService {

  /**
   * -用户登录
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage login(UserModel model) throws Exception;

}
