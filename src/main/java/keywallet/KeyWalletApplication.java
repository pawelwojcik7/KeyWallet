package keywallet;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class KeyWalletApplication {

    public static void main(String[] args) {

        SpringApplication.run(KeyWalletApplication.class, args);
    }

}
