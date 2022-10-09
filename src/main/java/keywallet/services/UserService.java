package keywallet.services;

import keywallet.DAO.UserDAO;
import keywallet.providers.EncryptionAlgorithmProvider;
import keywallet.providers.SaltProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EncryptionAlgorithmProvider encryptionAlgorithmProvider;
    private final UserDAO userRepository;
    private final SaltProvider saltProvider;

    public void createUser(){
        String salt = saltProvider.getSalt();
    }

}
