package com.banquito.product.associated_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banquito.product.associated_service.controller.dto.AccountServiceAssociatedParamRQ;
import com.banquito.product.associated_service.controller.mapper.AccountServiceAssociatedParamMapper;
import com.banquito.product.associated_service.service.AccountServiceParamService;
import com.banquito.product.associated_service.service.AssocietadServiceService;

@Controller
@RequestMapping("api/accountAssociatedServiceParam")
public class AccountServiceAssociatedParamController {

    private final AssocietadServiceService associetadServiceParam;
    private final AccountServiceParamService accountServiceParam;

  

    public AccountServiceAssociatedParamController(AssocietadServiceService associetadServiceParam,
            AccountServiceParamService accountServiceParam) {
        this.associetadServiceParam = associetadServiceParam;
        this.accountServiceParam = accountServiceParam;
    }

    @ResponseBody
    @RequestMapping(value = " ", method = RequestMethod.POST)
    public ResponseEntity<String> createAccountServiceAssociatedParam(@RequestBody AccountServiceAssociatedParamRQ paramRQ){
        try {
            this.associetadServiceParam.createAccountServiceAssociatedParam(AccountServiceAssociatedParamMapper.toAccountParam(paramRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }  
    }

    @ResponseBody
    @RequestMapping(value = "/all/{id}/{codeAccount}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAccountServiceAssoParam(@PathVariable("id") String id, @PathVariable("codeAccount") String codeAccount, @RequestBody String status) {                                               
		try {
            this.accountServiceParam.updateAccountServiceParam(id, codeAccount, status);;
		    return ResponseEntity.ok("Account Param's Information updated");
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();

        }
        
	}
}

