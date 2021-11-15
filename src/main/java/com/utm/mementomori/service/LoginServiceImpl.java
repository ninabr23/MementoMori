package com.utm.mementomori.service;

import com.utm.mementomori.dao.LoginDao;
import com.utm.mementomori.dto.LoginDTO;
import com.utm.mementomori.models.Accounts;
import com.utm.mementomori.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao<Accounts> loginDao;

    @Autowired
    private AccountsRepository repository;

    static Logger log = Logger.getLogger(LoginServiceImpl.class.getName());

    @Override
    public ResponseEntity<String> checkExistence(LoginDTO loginDTO) {
        Accounts account = loginDao.getSingleByEmail(loginDTO.getEmail());

        if (account != null && account.getPassword().equals(loginDTO.getPassword()))
            return new ResponseEntity<>("Your account is safe with us!", HttpStatus.OK);
        return new ResponseEntity<>("Such an account could not be found.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> update(LoginDTO loginDTO) {
        Accounts account = loginDao.getSingleByEmail(loginDTO.getEmail());
        if (account != null) {
            if (isValidPassword(loginDTO.getPassword())) {
                loginDao.updatePassword(account, loginDTO.getPassword());
                return new ResponseEntity<>("Your account was successfully updated with the following information:\n"
                        + account, HttpStatus.OK);
            } else log.info("New password invalid. Please choose another one.");
        } else log.info("Account with such an email does not exist.");
        return new ResponseEntity<>("Your account was not updated. Verify the correctitude of the typed in " +
                "information and try again.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public void save(Accounts account) {
        repository.save(account);
    }

    private boolean isValidPassword(String password) {
        /*
        Must have at least one numeric character.
        Must have at least one lowercase and uppercase character.
        Must be between 6 and 20 characters, both inclusive.
        */
        final String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
