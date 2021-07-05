package com.example.bookapp.controller;

import com.example.bookapp.model.dto.UserDto;
import com.example.bookapp.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(!userDto.getPassword().equals(userDto.getRepeatPassword())){
            bindingResult.rejectValue("password","Passwords not equals");
            return "register";
        }
        userServiceImpl.createUser(userDto);
        return "redirect:/login";
    }

}
