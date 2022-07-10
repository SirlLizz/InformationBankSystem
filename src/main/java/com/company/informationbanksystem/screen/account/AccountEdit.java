package com.company.informationbanksystem.screen.account;

import io.jmix.core.Metadata;
import io.jmix.ui.component.CheckBox;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.informationbanksystem.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.collect.Lists;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

import java.util.List;

@UiController("Account.edit")
@UiDescriptor("account-edit.xml")
@EditedEntityContainer("accountDc")
public class AccountEdit extends StandardEditor<Account> {

    @Autowired
    protected ComboBox<String> currencyComboBox;

    @Subscribe
    protected void onInit(InitEvent event) {

        List<String> options = Lists.newArrayList(
                "AED", "AFN", "ALL", "AMD", "AUD",
                "BMD", "BHD", "BIF", "BYR", "CAD",
                "CHF", "CNY", "CUP", "EUR", "GBP",
                "HKD", "JPY", "KWP", "KZT", "NOK",
                "RUB", "THB", "TWD", "UAH", "USD",
                "XAF", "XOF", "XPF", "ZAR", "ZWL");
        currencyComboBox.setOptionsList(options);

    }
}