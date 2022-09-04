package com.task.recruiting.reposotory;

import com.task.recruiting.entity.BlacklistFido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Репозиторий таблицы blacklist_fido
 */
@Repository
public interface BlacklistFidoRepo extends JpaRepository<BlacklistFido, Long> {
        /**
         * @param fido ФИО
         * @return сущность таблицы blacklist_fido
         */
        BlacklistFido findByFido(String fido);
}
