package com.restapi.restiwak.dao;

import com.restapi.restiwak.pojo.Broadcast;

import java.util.List;

public interface BroadcastDao {
    List<Broadcast> broadcastListByRt(String rt);
}
