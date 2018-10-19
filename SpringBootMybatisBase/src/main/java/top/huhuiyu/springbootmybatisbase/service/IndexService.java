package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.entity.JsonMessage;

/**
 * Index服务类
 * 
 * @author DarkKnight
 *
 */
public interface IndexService {

  /**
   * 首页显示信息
   * @return
   * @throws Exception
   */
  JsonMessage index() throws Exception;

}
