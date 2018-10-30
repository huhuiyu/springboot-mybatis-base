package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;
import top.huhuiyu.springbootmybatisbase.model.TestModel;
import top.huhuiyu.springbootmybatisbase.service.TestService;
import top.huhuiyu.springbootmybatisbase.service.UtilService;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试控制器
 *
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private TestService testService;
  @Autowired
  private UtilService utilService;

  @RequestMapping("queryTokens")
  public JsonMessage queryTokens(TestModel model) throws Exception {
    // {"page.pageNumber":1,"page.pageSize":5}
    return testService.queryTokens(model.getPage());
  }

  @RequestMapping("/checkImageCode")
  public JsonMessage checkImageCode(TestModel model) throws Exception {
    // {"imageCode":""}
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tokenInfo.setInfo(model.getImageCode());
    boolean result = utilService.checkImageCode(tokenInfo);
    return result ? JsonMessage.getSuccess("图片校验码正确") : JsonMessage.getFail("图片校验码错误");
  }
}
