package com.restapi.restiwak.repo;

import com.restapi.restiwak.pojo.Pengeluaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PengeluaranRepository extends JpaRepository<Pengeluaran, Integer> {
}