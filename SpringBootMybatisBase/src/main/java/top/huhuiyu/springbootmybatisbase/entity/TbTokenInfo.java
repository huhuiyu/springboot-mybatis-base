package top.huhuiyu.springbootmybatisbase.entity;

import java.util.Date;

/**
 * TbTokenInfo表
 * 
 * @author DarkKnight
 *
 */
public class TbTokenInfo extends BaseEntity {
  private static final long serialVersionUID = 1035854263020859388L;
  private String token;
  private String infokey;
  private String info;
  private Date lastupdate;

  public TbTokenInfo() {
  }

  public TbTokenInfo(String token, String infokey, String info, Date lastupdate) {
    this.token = token;
    this.infokey = infokey;
    this.info = info;
    this.lastupdate = lastupdate;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getInfokey() {
    return infokey;
  }

  public void setInfokey(String infokey) {
    this.infokey = infokey;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
