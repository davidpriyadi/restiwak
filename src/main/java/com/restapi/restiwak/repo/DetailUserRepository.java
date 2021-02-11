package com.restapi.restiwak.repo;

import com.restapi.restiwak.pojo.DetailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailUserRepository extends JpaRepository<DetailUser, Integer> {
}