package com.company.informationbanksystem.security;

import com.company.informationbanksystem.entity.Account;
import com.company.informationbanksystem.entity.Operation;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "Operations editor", code = "operations-editor")
public interface OperationsEditorRole {

    @EntityAttributePolicy(entityClass = Account.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Account.class, actions = EntityPolicyAction.READ)
    @ScreenPolicy(screenIds = {"Account.browse", "Account.edit"})
    @MenuPolicy(menuIds = "Account.browse")
    void account();

    @EntityAttributePolicy(entityClass = Operation.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Operation.class, actions = EntityPolicyAction.ALL)
    @ScreenPolicy(
            screenIds = {"Operation.edit"})
    void operation();
}