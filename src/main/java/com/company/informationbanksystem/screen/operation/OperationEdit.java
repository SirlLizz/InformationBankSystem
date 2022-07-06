package com.company.informationbanksystem.screen.operation;

import io.jmix.ui.screen.*;
import com.company.informationbanksystem.entity.Operation;

@UiController("Operation.edit")
@UiDescriptor("operation-edit.xml")
@EditedEntityContainer("operationDc")
public class OperationEdit extends StandardEditor<Operation> {
}