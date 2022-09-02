package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.BadCompany;
import com.task.recruiting.entity.BlacklistFido;
import com.task.recruiting.reposotory.BlacklistFidoRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class BadFidoChecker {
    @Autowired
    private BlacklistFidoRepo blacklistFidoRepo;

    public boolean checkFido(String fido){
        BlacklistFido badFido = blacklistFidoRepo.findByFido(fido);
        return badFido == null;
    }
}
