package ucr.ac.cr.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.userservice.entity.BankAccount;
import ucr.ac.cr.userservice.repository.BankAccountRepository;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public List<BankAccount> getBankAccounts() {
        return (List<BankAccount>) this.bankAccountRepository.findAll();
    }

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }

}
