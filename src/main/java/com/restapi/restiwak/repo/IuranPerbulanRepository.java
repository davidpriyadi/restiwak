package com.restapi.restiwak.repo;

import com.restapi.restiwak.pojo.IuranPerbulan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IuranPerbulanRepository extends JpaRepository<IuranPerbulan, Integer> {
}