package com.restapi.restiwak.repo;

import com.restapi.restiwak.pojo.JenisIuran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisIuranRepository extends JpaRepository<JenisIuran, Integer> {
}