package ru.dlosev.kateteria.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("kateteria.img")
public class ImgProperties {

	String path;

	String smallPostfix;

	String largePostfix;

	String extension;
}
