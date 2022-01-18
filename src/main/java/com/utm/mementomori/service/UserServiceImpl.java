package com.utm.mementomori.service;

import com.utm.mementomori.dao.LoginDao;
import com.utm.mementomori.dao.UserDao;
import com.utm.mementomori.dto.UserDTO;
import com.utm.mementomori.models.Accounts;
import com.utm.mementomori.models.User;
import com.utm.mementomori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao<User> userDao;

    @Autowired
    private LoginDao<Accounts> loginDao;

    @Autowired
    private UserRepository repository;

    @Override
    public ModelAndView validate(UserDTO userDTO) {
        User user = userDao.getSingleByEmail(userDTO.getEmail());
        Accounts account = loginDao.getSingleByEmail(userDTO.getEmail());

        if (user != null && user.getAccount().equals(account) && account.getPassword().equals(userDTO.getPassword())) {
            ModelAndView modelAndView = new ModelAndView("userPage");
            modelAndView.addObject("user", userDTO);
            return modelAndView;
        } else return new ModelAndView("index").addObject("user", "Incorrect password.");
    }

    public boolean validateBoolean(UserDTO userDTO) {
        User user = userDao.getSingleByEmail(userDTO.getEmail());
        Accounts account = loginDao.getSingleByEmail(userDTO.getEmail());

        return user != null && account != null && account.getPassword().equals(userDTO.getPassword());
    }

    @Override
    public ModelAndView update(UserDTO userDTO) {
        User user = userDao.getSingleByEmail(userDTO.getEmail());
        Accounts account = loginDao.getSingleByEmail(userDTO.getEmail());
        if (user != null && user.getAccount().equals(account) && validateBoolean(userDTO)) {
            userDao.updateFirstName(user, userDTO.getFirstName());
            userDao.updateLastName(user, userDTO.getLastName());
            userDao.updateEmail(user, userDTO.getEmail());
            if(!userDTO.getNewPassword().isBlank())
                userDao.updatePassword(user, userDTO.getNewPassword());
            userDao.updateBirthdate(user, userDTO.getBday());
            userDao.updateCountry(user, userDTO.getCountry());
        }
        return new ModelAndView("userPage");
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
