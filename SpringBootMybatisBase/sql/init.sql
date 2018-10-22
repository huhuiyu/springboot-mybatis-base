use SpringBootMybatisBase;

/* 清除数据 */
truncate table TbConfig;
truncate table TbUser;
truncate table TbToken;
truncate table TbTokenInfo;

/*token过期时间配置*/
insert into TbConfig(configKey,configValue) values('token.timeout','30');

/*添加默认用户*/
insert into TbUser(username,password,nickname)
  values('test','test-pwd','测试用户');

/*查询*/
select configKey,configValue,lastupdate from TbConfig;
select uid,username,password,nickname,isEnable,regDate from TbUser;
select token,uid,lastupdate from TbToken;
select token,infokey,info,lastupdate from TbTokenInfo;
