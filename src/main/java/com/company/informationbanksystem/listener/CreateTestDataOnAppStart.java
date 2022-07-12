package com.company.informationbanksystem.listener;

import com.company.informationbanksystem.app.OperationTestDataCreation;
import io.jmix.core.security.Authenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

@Component
public class CreateTestDataOnAppStart {

    @Autowired
    OperationTestDataCreation operationTestDataCreation;

    @Authenticated
    @EventListener
    public void onApplicationStarted(ApplicationStartedEvent event) {
        operationTestDataCreation.createData();
    }
}