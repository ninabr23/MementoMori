package com.utm.mementomori.service;

import com.utm.mementomori.dao.LoginDao;
import com.utm.mementomori.dto.LoginDTO;
import com.utm.mementomori.models.Accounts;
import com.utm.mementomori.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView checkExistence(LoginDTO loginDTO) {
        Accounts account = loginDao.getSingleByEmail(loginDTO.getEmail());

        if (account != null && account.getPassword().equals(loginDTO.getPassword())) {
            ModelAndView modelAndView = new ModelAndView("userPage");
            modelAndView.addObject("user", loginDTO.getEmail());
            return modelAndView;
        } else return new ModelAndView("index").addObject("user", "invalidEmail");
    }

    @Override
    public ModelAndView update(LoginDTO loginDTO) {
        Accounts account = loginDao.getSingleByEmail(loginDTO.getEmail());
        if (account != null) {
            if (isValidPassword(loginDTO.getPassword())) {
                loginDao.updatePassword(account, loginDTO.getPassword());
                ModelAndView modelAndView = new ModelAndView("userPage");
                modelAndView.addObject("userDTO", loginDTO);
                return modelAndView;
            } else log.info("New password invalid.");
        } else log.info("Email does not exist.");
        return new ModelAndView("index");
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
