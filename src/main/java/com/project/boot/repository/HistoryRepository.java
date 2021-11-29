package com.project.boot.repository;

import com.project.boot.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, String> {

    @Query("SELECT obj FROM History obj WHERE obj.client_id = ?1 ORDER BY obj.date")
    List<History> findByClientId(String client_id);

}
