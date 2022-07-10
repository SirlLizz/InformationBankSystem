package com.company.informationbanksystem.security;

import com.company.informationbanksystem.entity.Account;
import com.company.informationbanksystem.entity.Operation;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.*;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "Account editor", code = "account-editor")
public interface AccountEditorRole {

    @EntityAttributePolicy(entityClass = Account.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Account.class, actions = EntityPolicyAction.ALL)
    @ScreenPolicy(screenIds = {"Account.browse", "Account.edit"})
    @MenuPolicy(menuIds = "Account.browse")
    void account();

    @EntityAttributePolicy(entityClass = Operation.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Operation.class, actions = EntityPolicyAction.ALL)
    @ScreenPolicy(
            screenIds = {"Operation.edit"})
    void operation();
}