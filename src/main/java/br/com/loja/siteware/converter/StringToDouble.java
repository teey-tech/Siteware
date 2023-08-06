package br.com.loja.siteware.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDouble implements Converter<String, Double> {

  @Override
  public Double convert(String source) {
    // Remover espaço em branco
    source = source.trim();

    if (source.length() > 0) {
      source = source.replace(".", "").replace(",", ".");
      return Double.parseDouble(source);
    }
    return 0.;
  }

}
