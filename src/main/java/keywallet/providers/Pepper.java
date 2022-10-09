package keywallet.providers;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class Pepper {

    private String pepper;

}
