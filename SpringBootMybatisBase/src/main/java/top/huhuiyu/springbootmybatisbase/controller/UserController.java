package top.huhuiyu.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springbootmybatisbase.model.UserModel;
import top.huhuiyu.springbootmybatisbase.service.UserService;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;

/**
 * -用户信息控制器
 *
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  public JsonMessage login(UserModel model) throws Exception {
    // {"user.username":"test","user.password":"test-pwd"}
    return userService.login(model);
  }

  @RequestMapping("/logout")
  public JsonMessage logout(UserModel model) throws Exception {
    // {}
    return userService.logout(model);
  }

  @RequestMapping("/queryUserInfo")
  public JsonMessage queryUserInfo(UserModel model) throws Exception {
    // {}
    return userService.queryUserInfo(model);
  }

}
