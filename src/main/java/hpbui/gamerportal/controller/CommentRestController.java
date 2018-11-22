package hpbui.gamerportal.controller;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.service.AccountService;
import hpbui.gamerportal.service.CommentService;
import hpbui.gamerportal.viewmodel.CommentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentRestController {
    @Autowired
    CommentService commentService;
    @Autowired
    AccountService accountService;

    @PostMapping(value = "/comments/add")
    @ResponseStatus(value = HttpStatus.OK)
    public void addComment(CommentViewModel model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        Account accountFrom = accountService.findAccountByUsername(userDetails.getUsername());
        commentService.addComment(accountFrom.getId(), model.getToUserId(),
                model.getText(), model.getScore(), model.getParentId());
    }

    @GetMapping(value = "/comments/{userId}")
    public void getComments(@PathVariable long userId) {

    }
}
