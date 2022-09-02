package com.task.recruiting.reposotory;

import com.task.recruiting.entity.BadCompany;
import com.task.recruiting.entity.BlacklistFido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistFidoRepo extends JpaRepository<BlacklistFido, Long> {
        BlacklistFido findByFido(String fido);
}
