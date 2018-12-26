package com.adifier.web;

import com.adifier.domain.User;
import com.adifier.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String register(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               @RequestParam int phone){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.save(user);

        return "redirect:/login";
    }
}
