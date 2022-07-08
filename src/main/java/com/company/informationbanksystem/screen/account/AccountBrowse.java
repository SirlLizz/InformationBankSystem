package com.company.informationbanksystem.screen.account;

import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Component;
import io.jmix.ui.screen.*;
import com.company.informationbanksystem.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Account.browse")
@UiDescriptor("account-browse.xml")
@LookupComponent("accountsTable")
public class AccountBrowse extends StandardLookup<Account> {
}