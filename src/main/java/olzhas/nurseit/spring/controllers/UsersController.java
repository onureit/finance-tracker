package olzhas.nurseit.spring.controllers;

import olzhas.nurseit.spring.daos.TransactionDAO;
import olzhas.nurseit.spring.daos.UserDAO;
import olzhas.nurseit.spring.models.Transaction;
import olzhas.nurseit.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDAO userDAO;
    private final TransactionDAO transactionDAO;

    @Autowired
    public UsersController(UserDAO userDAO, TransactionDAO transactionDAO){
        this.userDAO = userDAO;
        this.transactionDAO = transactionDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userDAO.index());
        return "users/indexUsers";
    }



    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute @Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "users/newUser";
        }
        userDAO.save(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model){
        model.addAttribute("user", userDAO.show(id));
        model.addAttribute("transactions", transactionDAO.index(id));
        model.addAttribute("transaction",  new Transaction());
        return "users/showUser";
    }

}
