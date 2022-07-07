package com.company.informationbanksystem.screen.operation;

import com.google.common.collect.Lists;
import io.jmix.core.Metadata;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.DatePicker;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.informationbanksystem.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@UiController("Operation.edit")
@UiDescriptor("operation-edit.xml")
@EditedEntityContainer("operationDc")
public class OperationEdit extends StandardEditor<Operation> {

    @Autowired
    private MessageBundle messageBundle;

    @Autowired
    protected ComboBox<String> typeComboBox;

    @Autowired
    protected ComboBox<String> categoryComboBox;

    @Subscribe
    protected void onInit(InitEvent event) {

        List<String> typeOptions = Lists.newArrayList(
                messageBundle.getMessage("withdrawal"),
                messageBundle.getMessage("transfer"));
        typeComboBox.setOptionsList(typeOptions);

        List<String> categoryOptions = Lists.newArrayList(
                messageBundle.getMessage("accountOpening"),
                messageBundle.getMessage("contribution"),
                messageBundle.getMessage("dragMetal"),
                messageBundle.getMessage("foreignExchange"),
                messageBundle.getMessage("encasement"),
                messageBundle.getMessage("loan"));
        categoryComboBox.setOptionsList(categoryOptions);
    }

}