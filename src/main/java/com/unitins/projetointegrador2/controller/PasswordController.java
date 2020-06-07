package com.unitins.projetointegrador2.controller;


import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.services.EmailService;
import com.unitins.projetointegrador2.services.UserService;

@Controller
public class PasswordController {

    private final UserService userService;

    private final EmailService emailService;

    public PasswordController(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping(value = "/forgot")
    public ModelAndView displayForgotPasswordPage() {
        return new ModelAndView("esqueciSenha");
    }

    @PostMapping(value = "/forgot")
    public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request) {

        Optional<Pessoa> optional = userService.findUserByEmail(userEmail);

        if (!optional.isPresent()) {
            modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
        } else {

            Pessoa user = optional.get();
            user.setResetToken(UUID.randomUUID().toString());

            userService.saveUser(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();

            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("hygorsousaraujo@gmail.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Pedido de alteração de senha");
            passwordResetEmail.setText("Para alterar sua senha, clique no link abaixo:\n" + appUrl
                    + ":8080/reset?token=" + user.getResetToken());

            emailService.sendEmail(passwordResetEmail);

            modelAndView.addObject("successMessage", "A password reset link has been sent to " + userEmail);
        }

        modelAndView.setViewName("esqueciSenha");
        return modelAndView;

    }

    @GetMapping(value = "/reset")
    public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        Optional<Pessoa> user = userService.findUserByResetToken(token);

        if (user.isPresent()) {
            modelAndView.addObject("resetToken", token);
        } else {
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
        }

        modelAndView.setViewName("resetarSenha");
        return modelAndView;
    }

    @PostMapping(value = "/reset")
    public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        Optional<Pessoa> user = userService.findUserByResetToken(requestParams.get("token"));

        if (user.isPresent()) {

            Pessoa resetUser = user.get();

            resetUser.setSenha(new BCryptPasswordEncoder().encode(requestParams.get("password")));

            resetUser.setResetToken(null);

            userService.saveUser(resetUser);

            redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");

            modelAndView.setViewName("redirect:login");
            return modelAndView;

        } else {
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
            modelAndView.setViewName("resetarSenha");
        }

        return modelAndView;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        return new ModelAndView("redirect:login");
    }
}