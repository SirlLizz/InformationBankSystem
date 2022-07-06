package com.company.informationbanksystem.screen.operation;

import com.google.common.collect.Lists;
import io.jmix.core.Metadata;
import io.jmix.ui.component.ComboBox;
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
    protected InstanceContainer<Operation> operationDc;
    @Autowired
    protected Metadata metadata;

    @Subscribe
    protected void onInit(InitEvent event) {
        List<String> options = Lists.newArrayList(
                messageBundle.getMessage("withdrawal"),
                messageBundle.getMessage("transfer"));
        typeComboBox.setOptionsList(options);

        Operation operation = metadata.create(Operation.class);
        operation.setDate(new Date());
        operationDc.setItem(operation);

    }

}