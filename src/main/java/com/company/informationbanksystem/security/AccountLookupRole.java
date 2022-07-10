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


@ResourceRole(name = "Account lookup", code = "account-lookup")
public interface AccountLookupRole {

    @MenuPolicy(menuIds = "Account.browse")
    @ScreenPolicy(screenIds = {"Account.browse", "MainScreen"})
    void screens();

    @EntityAttributePolicy(entityClass = Account.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Account.class, actions = EntityPolicyAction.READ)
    void account();

    @EntityPolicy(entityClass = Operation.class, actions = EntityPolicyAction.READ)
    @EntityAttributePolicy(entityClass = Operation.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void operation();
}