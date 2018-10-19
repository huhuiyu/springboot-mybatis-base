package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.entity.JsonMessage;
import top.huhuiyu.springbootmybatisbase.model.IndexModel;
import top.huhuiyu.springbootmybatisbase.service.IndexService;

/**
 * 默认首页控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
public class IndexController {
  @Autowired
  private IndexService indexService;

  @RequestMapping("")
  public JsonMessage index(IndexModel model) throws Exception {
    // http://127.0.0.1:14000/?echo=abc-123&token=
    JsonMessage message = indexService.index();
    message.put("echo", model.getEcho());
    return message;
  }
}