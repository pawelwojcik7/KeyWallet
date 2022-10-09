package keywallet.interfaces;

public interface EncryptAlgorithm {

    String encrypt(String text);
    String decrypt(String text);
    String getName();

}
