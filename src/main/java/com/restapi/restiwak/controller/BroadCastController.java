package com.restapi.restiwak.controller;

import com.restapi.restiwak.dao.BroadcastDao;
import com.restapi.restiwak.pojo.Broadcast;
import com.restapi.restiwak.service.BroadCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BroadCastController {
    @Autowired
    private BroadcastDao broadcastDao;
    @Autowired
    private BroadCastService broadCastService;

    public BroadCastController() {
    }

    @GetMapping({"/broadcast/{rt}"})
    public List<Broadcast> broadcastByRT(@PathVariable("rt") String rt) {
        return this.broadcastDao.broadcastListByRt(rt);
    }

    @PostMapping({"/broadcast/save"})
    public ResponseEntity<Broadcast> addBroadcast(@RequestBody Broadcast broadcast) {
        Broadcast newBroadcast1 = this.broadCastService.save(broadcast);
        return new ResponseEntity(newBroadcast1, HttpStatus.CREATED);
    }

    @DeleteMapping({"/broadcast/delete/{id}"})
    public ResponseEntity<Broadcast> deleteResponseEntity(@PathVariable("id") Integer id) {
        this.broadCastService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping({"/broadcast/update"})
    public ResponseEntity<Broadcast> updateResponseEntity(@RequestBody Broadcast broadcast) {
        Broadcast newBroadcast1 = this.broadCastService.save(broadcast);
        return new ResponseEntity(newBroadcast1, HttpStatus.OK);
    }
}

