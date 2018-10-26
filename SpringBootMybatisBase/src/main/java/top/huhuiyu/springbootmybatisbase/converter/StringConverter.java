package top.huhuiyu.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 * String数值转换器
 *
 * @author DarkKnight
 *
 */
@Component
public class StringConverter implements Converter<String, String> {

  @Override
  public String convert(String source) {
    return MyUtils.trim(source);
  }

}
