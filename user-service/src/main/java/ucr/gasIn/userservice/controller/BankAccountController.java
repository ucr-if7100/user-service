package ucr.ac.cr.userservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.userservice.entity.BankAccount;
import ucr.ac.cr.userservice.service.BankAccountService;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;
    @GetMapping
    public List<BankAccount> getBankAccounts() {
        return this.bankAccountService.getBankAccounts();
    }
    @PostMapping
    public BankAccount saveBankAccount
            (@RequestBody BankAccount bankAccount) {
        return this.bankAccountService.saveBankAccount(bankAccount);
    }

}
