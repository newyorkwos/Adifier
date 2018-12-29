package com.adifier.web;

import com.adifier.domain.User;
import com.adifier.domain.UserRepository;
import com.adifier.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 描述:
 * create Login Controller
 *
 * @author StevenWu
 * @create 2018-12-24-21:54
 */
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/login")
    public String longPage(){
        return "login";
    }

    @PostMapping("/register")
    public String register(UserForm userForm){
        User user=userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }
}
