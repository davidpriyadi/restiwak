package com.restapi.restiwak.repo;

import com.restapi.restiwak.pojo.TransaksiIuran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiIuranRepository extends JpaRepository<TransaksiIuran, Integer> {
}