package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.OperationDto;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.AccountService;
import ua.com.alevel.service.UserService;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping("/byUserId/{userId}")
    public String findAllByUserId(Model model, @PathVariable Long userId) {
        model.addAttribute("user", userService.findUserById(userId));
        model.addAttribute("accounts", accountService.findAllByUserId(userId));
        return "accounts_by_user_id";
    }

    @GetMapping("/createNewUserAccount/{userId}")
    public String createAccountByUser(Model model, @PathVariable Long userId) {
        Account account = new Account();
        //  account.setX(11); todo если создать поле в классе аккаунт и засетать его здесь то в пост маппинге оно будет null
//        account.setUser(user); // todo в пост маппинге аккаунт прилетает без юзера
        User user = userService.findUserById(userId);
        model.addAttribute("account", account);
        model.addAttribute("user", user);
        return "account_new_by_user";
    }

    @PostMapping("/createNewUserAccount/{userId}")
    public String createAccountByUser(@ModelAttribute("account") Account account,
                                      @PathVariable Long userId) {
        //    System.out.println(account.getX());  // <-  todo тут null, значение поля удалилось
        account.setUser(userService.findUserById(userId)); // todo поэтому сетаю юзера здесь
        accountService.create(account);
        return "redirect:/accounts/byUserId/{userId}";
    }

    @GetMapping("/send/{accountFromId}")
    public String sendRequest(Model model, @PathVariable Long accountFromId) {
        OperationDto operationDto = new OperationDto();
        operationDto.setAccountFromId(accountFromId);
        model.addAttribute("operationDto", operationDto);
        model.addAttribute("accFromId", accountFromId);
        return "account_send_form";
    }

    @PostMapping("/confirmOperation/{accountFromId}")
    public String confirmOperation(@ModelAttribute("operationDto") OperationDto operationDto,@PathVariable Long accountFromId , Model model) {
        System.out.println("confirm  " + operationDto); // todo здесь это поле null

        if (accountService.checkIfAccountExistByNumber(operationDto.getAccountToNumber())
                && operationDto.getOperationSum() > 0
                && accountService.findById(operationDto.getAccountFromId()).getBalance() >= operationDto.getOperationSum()) {
            Account accountToEntity = accountService.findByNumber(operationDto.getAccountToNumber());
            User userTo = accountService.findUserByAccountId(accountToEntity.getId());
            model.addAttribute("userTo", userTo);
            model.addAttribute("operationDto", operationDto);
            return "confirm_operation";
        }
        return "error";
    }

    @PostMapping("/sendFinally/{accountFromId}")
    public String sendFinally(@ModelAttribute("operationDto") OperationDto operationDto, @PathVariable Long accountFromId) {
        System.out.println("hi");
        System.out.println(operationDto);
//            operation.setAccountFrom(accountService.findById(accountFromId));
//            accountService.send(operation, accountTo.getNumber());
//            User userFrom = accountService.findUserByAccountId(accountFromId);
            return "redirect:/users";
    }
}
