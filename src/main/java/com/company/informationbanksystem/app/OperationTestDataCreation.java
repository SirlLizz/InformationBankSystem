package com.company.informationbanksystem.app;

import com.company.informationbanksystem.entity.Account;
import com.company.informationbanksystem.entity.Operation;
import com.google.common.collect.Lists;
import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import io.jmix.core.TimeSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Component("OperationTestDataCreation")
public class OperationTestDataCreation {

    private static final Logger log = LoggerFactory.getLogger(OperationTestDataCreation.class);

    @Autowired
    private Messages messages;
    protected final TimeSource timeSource;
    protected final DataManager dataManager;

    public OperationTestDataCreation(TimeSource timeSource, DataManager dataManager) {
        this.timeSource = timeSource;
        this.dataManager = dataManager;
    }

    public void createData() {

        if (accountsExists()) {
            log.info("Account found in DB. Account Test data generation is skipped...");
            return;
        }
        log.info("No Accounts found in the DB. Accounts Test data will be created...");
        createAccounts();
    }

    void createAccounts() {
        for(int i = 0 ; i < 50; i++){
            Account account = dataManager.create(Account.class);
            account.setArchive(randomArchive());
            account.setCurrency(randomCurrency());
            account.setFunds((double) 0);
            account.setName(Integer.toString(i+1));

            dataManager.save(account);
            for(int j = 0; j< i; j++){
                Operation operation = dataManager.create(Operation.class);
                operation.setAccount(account);
                operation.setDate(new Date());
                operation.setSum((long) (Math.random() * 10000L));
                operation.setCategory(randomCategory());
                operation.setType(randomType());

                dataManager.save(operation);
            }
        }
    }

    private boolean accountsExists() {
        return !list(Account.class).isEmpty();
    }

    private Boolean randomArchive(){
        return random().nextBoolean();
    }

    private String randomType(){
        if(random().nextBoolean()){
            return messages.getMessage("com.company.informationbanksystem.screen.operation/withdrawal");
        }else{
            return messages.getMessage("com.company.informationbanksystem.screen.operation/transfer");
        }
    }

    private String randomCategory(){
        List<String> options = Lists.newArrayList(
                messages.getMessage("com.company.informationbanksystem.screen.operation/accountOpening"),
                messages.getMessage("com.company.informationbanksystem.screen.operation/contribution"),
                messages.getMessage("com.company.informationbanksystem.screen.operation/dragMetal"),
                messages.getMessage("com.company.informationbanksystem.screen.operation/encasement"),
                messages.getMessage("com.company.informationbanksystem.screen.operation/loan"),
                messages.getMessage("com.company.informationbanksystem.screen.operation/foreignExchange"));
        return options.get(random().nextInt(5));
    }

    private String randomCurrency(){
        List<String> options = Lists.newArrayList(
                "AED", "AFN", "ALL", "AMD", "AUD",
                "BMD", "BHD", "BIF", "BYR", "CAD",
                "CHF", "CNY", "CUP", "EUR", "GBP",
                "HKD", "JPY", "KWP", "KZT", "NOK",
                "RUB", "THB", "TWD", "UAH", "USD",
                "XAF", "XOF", "XPF", "ZAR", "ZWL");
        return options.get(random().nextInt(29));
    }

    private <T> T randomOfList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(random().nextInt(list.size()));
    }

    private Random random() {
        return new Random();
    }

    private <T> List<T> list(Class<T> entityClass) {
        return dataManager.load(entityClass).all().list();
    }
}
