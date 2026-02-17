package olzhas.nurseit.spring.controllers;

import olzhas.nurseit.spring.daos.TransactionDAO;
import olzhas.nurseit.spring.daos.UserDAO;
import olzhas.nurseit.spring.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TransactionController {
    private final TransactionDAO transactionDAO;
    private final UserDAO userDAO;

    @Autowired
    public TransactionController(TransactionDAO transactionDAO,  UserDAO userDAO) {
        this.transactionDAO = transactionDAO;
        this.userDAO = userDAO;
    }

    @PostMapping("/users/{id}/transactions")
    public String createTransaction(@PathVariable int id,
                                    @Valid @ModelAttribute("transaction") Transaction transaction,
                                    BindingResult result,
                                    Model model) {

        if (result.hasErrors()) {
            model.addAttribute("user", userDAO.show(id));
            model.addAttribute("transactions", transactionDAO.index(id));
            System.out.println("OLAJSSSSSSS");
            return "users/showUser";
        }

        transaction.setUserId(id);
        transactionDAO.save(transaction);

        return "redirect:/users/" + id;
    }
}
