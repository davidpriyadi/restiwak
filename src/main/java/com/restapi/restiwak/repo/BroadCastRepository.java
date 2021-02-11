package com.restapi.restiwak.repo;

import com.restapi.restiwak.pojo.Broadcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadCastRepository extends JpaRepository<Broadcast, Integer> {
}