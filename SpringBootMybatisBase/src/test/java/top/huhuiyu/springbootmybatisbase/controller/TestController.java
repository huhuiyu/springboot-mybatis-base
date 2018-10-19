package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.entity.JsonMessage;
import top.huhuiyu.springbootmybatisbase.model.TestModel;
import top.huhuiyu.springbootmybatisbase.service.TestService;

/**
 * 测试控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;

  @RequestMapping("queryTokens")
  public JsonMessage queryTokens(TestModel model) throws Exception {
    // http://127.0.0.1:14000/test/queryTokens?page.pageNumber=1&page.pageSize=5&token=
    return testService.queryTokens(model.getPage());
  }
}
