package com.company.informationbanksystem.screen.account;

import io.jmix.ui.screen.*;
import com.company.informationbanksystem.entity.Account;

@UiController("Account.browse")
@UiDescriptor("account-browse.xml")
@LookupComponent("accountsTable")
public class AccountBrowse extends StandardLookup<Account> {

}