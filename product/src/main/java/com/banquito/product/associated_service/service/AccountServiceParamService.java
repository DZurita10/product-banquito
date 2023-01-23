package com.banquito.product.associated_service.service;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banquito.product.associated_service.model.AccountAssociatedServiceParam;
import com.banquito.product.associated_service.model.AssocietadService;
import com.banquito.product.associated_service.repository.AccountAssociatedServiceParamRepository;
import com.banquito.product.associated_service.repository.AssocietadServiceRepository;

@Service
public class AccountServiceParamService {
    

    private final AccountAssociatedServiceParamRepository  paramRepository;
    private final AssocietadServiceRepository serviceRepository;

    

    public AccountServiceParamService(AccountAssociatedServiceParamRepository paramRepository,
            AssocietadServiceRepository serviceRepository) {
        this.paramRepository = paramRepository;
        this.serviceRepository = serviceRepository;
    }

// List<AssocietadService> optional = this.serviceRepository.findByIdAndParamsAccountCodeAccount(codeAccount);
/* optional.forEach(services->{
    services.getParams().forEach(param->{
        param.getAccount().forEach(account->{
            account.setDateValue(LocalDateTime.now());
            account.setStatus(codeAccount);
        });
    });
    serviceRepository.save(services);
}); */
    
    public Boolean validateAccount(String accountNumber, AccountAssociatedServiceParam codeAccount){

        if(accountNumber.equals(codeAccount)){ 
            return true;
        }
        return false;
    }


    @Transactional
    public void updateAccountServiceParam ( String id,String codeAccount, String status){
        Optional<AssocietadService> optional = this.serviceRepository.findByIdAndParamsAccountCodeAccount(id,codeAccount);
        if(optional.isPresent()){
            AssocietadService service = optional.get();
            service.getParams().forEach(param->{
                param.getAccount().forEach(account->{
                    if(account.getCodeAccount().equals(codeAccount)){
                        account.setStatus(status);
                    }
                });
            });
            serviceRepository.save(service);
        }
    }
    


}
