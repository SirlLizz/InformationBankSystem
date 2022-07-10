package com.company.informationbanksystem.listener;

import com.company.informationbanksystem.entity.Account;
import com.company.informationbanksystem.entity.Operation;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.Messages;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.ui.screen.MessageBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.Objects;

@Component
public class OperationEventListener {

    @Autowired
    private Messages messages;

    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onOperationSaving(EntitySavingEvent<Operation> event) {
        if(event.isNewEntity()){
            if(Objects.equals(
                    event.getEntity().getType(),
                    messages.getMessage("com.company.informationbanksystem.screen.operation/withdrawal"))
            ){
                if(dataManager.load(Account.class).id(event.getEntity().getAccount().getId()).optional().isPresent()){
                    Account account = dataManager.load(Account.class).id(event.getEntity().getAccount()).one();
                    account.setFunds(
                            event.getEntity().getAccount().getFunds() - event.getEntity().getSum()
                    );
                    dataManager.save(account);
                }
                event.getEntity().getAccount().setFunds(event.getEntity().getAccount().getFunds() - event.getEntity().getSum());
            }else{
                if(dataManager.load(Account.class).id(event.getEntity().getAccount().getId()).optional().isPresent()){
                    Account account = dataManager.load(Account.class).id(event.getEntity().getAccount()).one();
                    account.setFunds(
                            event.getEntity().getAccount().getFunds() + event.getEntity().getSum()
                    );
                    dataManager.save(account);
                }
                event.getEntity().getAccount().setFunds(event.getEntity().getAccount().getFunds() + event.getEntity().getSum());
            }
        }
    }

    @EventListener
    public void onOperationChange(EntityChangedEvent<Operation> event) {
        if (event.getType() == EntityChangedEvent.Type.UPDATED
                && (event.getChanges().isChanged("sum") ||
                event.getChanges().isChanged("type")
        )) {
            Account account = dataManager.load(event.getEntityId()).one().getAccount();
            Double accountFund = account.getFunds();
            Long newSumOperation = dataManager.load(event.getEntityId()).one().getSum();
            Long oldSumOperation = newSumOperation;
            if(event.getChanges().isChanged("sum")){
                oldSumOperation = Long.parseLong(Objects.requireNonNull(event.getChanges().getOldValue("sum")).toString());
            }
            if(event.getChanges().getOldValue("type") == null){
                if(Objects.equals(
                        dataManager.load(event.getEntityId()).one().getType(),
                        messages.getMessage("com.company.informationbanksystem.screen.operation/withdrawal")
                )){
                    account.setFunds(accountFund - (newSumOperation - oldSumOperation));
                    dataManager.save(account);
                }else{
                    account.setFunds(accountFund + (newSumOperation - oldSumOperation));
                    dataManager.save(account);
                }
            }else{
                if(Objects.equals(
                        dataManager.load(event.getEntityId()).one().getType(),
                        messages.getMessage("com.company.informationbanksystem.screen.operation/withdrawal")
                )){
                    account.setFunds(accountFund - oldSumOperation - newSumOperation);
                    dataManager.save(account);
                }else{
                    account.setFunds(accountFund + oldSumOperation + newSumOperation);
                    dataManager.save(account);
                }
            }
        }
    }
}