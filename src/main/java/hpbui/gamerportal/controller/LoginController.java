package hpbui.gamerportal.controller;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {
	@Autowired
    private AccountServiceImpl accountServiceImpl;

    /**
     * Get Login page
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * Get Registration page
     * @return
     */
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Account account = new Account();
        modelAndView.addObject("account", account);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     * Handle register process
     * @param account
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Account account, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Account accountEntity = accountServiceImpl.findAccountByUsername(account.getUsername());
        if (accountEntity != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "This username is taken.");
        }
        accountEntity = accountServiceImpl.findAccountByEmail(account.getEmail());
        if (accountEntity != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            accountServiceImpl.addAccount(account);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("account", new Account());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
}
