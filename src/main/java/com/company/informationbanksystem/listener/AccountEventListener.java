package com.company.informationbanksystem.listener;

import com.company.informationbanksystem.entity.Account;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountEventListener {

    @EventListener
    public void onAccountSaving(EntitySavingEvent<Account> event) {
        if (event.getEntity().getArchive() == null) {
            event.getEntity().setArchive(false);
        }
    }
}