package top.huhuiyu.springbootmybatisbase.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.model.UtilModel;
import top.huhuiyu.springbootmybatisbase.service.UtilService;
import top.huhuiyu.springbootmybatisbase.utils.ImageCode;

/**
 * 工具类控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/util")
public class UtilController {

  @Autowired
  private UtilService utilService;

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    ImageIO.write(ImageCode.makeImage(utilService.imageCode(model.makeTokenInfo())), "jpeg", response.getOutputStream());
  }

}
