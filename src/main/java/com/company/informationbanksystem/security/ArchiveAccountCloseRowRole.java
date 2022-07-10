package com.company.informationbanksystem.security;

import com.company.informationbanksystem.entity.Account;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "ArchiveAccountClose", code = "archive-account-close")
public interface ArchiveAccountCloseRowRole {

    @JpqlRowLevelPolicy(
            entityClass = Account.class,
            where = "{E}.archive = false")
    void account();

}