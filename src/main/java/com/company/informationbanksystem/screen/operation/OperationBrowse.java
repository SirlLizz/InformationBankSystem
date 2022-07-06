package com.company.informationbanksystem.screen.operation;

import io.jmix.ui.screen.*;
import com.company.informationbanksystem.entity.Operation;

@UiController("Operation.browse")
@UiDescriptor("operation-browse.xml")
@LookupComponent("operationsTable")
public class OperationBrowse extends StandardLookup<Operation> {
}