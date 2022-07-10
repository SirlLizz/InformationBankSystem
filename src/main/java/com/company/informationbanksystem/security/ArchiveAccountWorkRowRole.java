package com.company.informationbanksystem.security;

import io.jmix.security.role.annotation.RowLevelRole;

@RowLevelRole(name = "ArchiveAccountWork", code = "archive-account-work")
public interface ArchiveAccountWorkRowRole {

    void account();

}