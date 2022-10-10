package keywallet.api;

import keywallet.models.Password;
import keywallet.models.User;
import keywallet.services.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KeyWalletController {

    private final PasswordService passwordService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){



        return ResponseEntity.ok().build();
    }

    @GetMapping("/passwords/{userId}")
    public ResponseEntity<List<Password>> gePasswordsForUser(@PathVariable Integer userId){

        return ResponseEntity.ok(passwordService.getPasswordForUser(userId));
    }

}
