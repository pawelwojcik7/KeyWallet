package keywallet.algorithms;

import keywallet.interfaces.EncryptAlgorithm;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

@Component
public class SSH512 implements EncryptAlgorithm {

    @SneakyThrows
    public String encrypt(String text) {

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(text.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
    }

    public String decrypt(String text) {
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    private String generateSalt(){
        return UUID.randomUUID().toString();
    }


}
