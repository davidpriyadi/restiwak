package com.restapi.restiwak.service;

import com.restapi.restiwak.pojo.Broadcast;
import com.restapi.restiwak.repo.BroadCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BroadCastService {
    @Autowired
    private BroadCastRepository broadCastRepository;

    public BroadCastService() {
    }

    public Broadcast save(Broadcast broadcast) {
        return (Broadcast)this.broadCastRepository.save(broadcast);
    }

    public Broadcast update(Broadcast broadcast) {
        return (Broadcast)this.broadCastRepository.save(broadcast);
    }

    public void delete(Integer id) {
        this.broadCastRepository.deleteById(id);
    }
}
