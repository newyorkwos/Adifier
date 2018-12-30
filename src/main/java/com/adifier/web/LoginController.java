package com.adifier.web;

import com.adifier.domain.User;
import com.adifier.domain.UserRepository;
import com.adifier.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * 描述:
 * create Login Controller
 *
 * @author StevenWu
 * @create 2018-12-30-18:56
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result, Model model) {

        if (!userForm.confirmPassword()) {
            result.rejectValue("confirmPassword","confirmError","兩次密碼不一致");

        }
        if (result.hasErrors()) {

            return "register";
        }
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }
}
