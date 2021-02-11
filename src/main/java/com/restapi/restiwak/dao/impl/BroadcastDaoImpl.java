package com.restapi.restiwak.dao.impl;

import com.restapi.restiwak.dao.BroadcastDao;
import com.restapi.restiwak.pojo.Broadcast;
import com.restapi.restiwak.pojo.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class BroadcastDaoImpl implements BroadcastDao {
    @PersistenceContext
    EntityManager entityManager;

    public BroadcastDaoImpl() {
    }

    public List<Broadcast> broadcastListByRt(String rt) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Broadcast> criteriaQuery = criteriaBuilder.createQuery(Broadcast.class);
        Root<Broadcast> broadcastRoot = criteriaQuery.from(Broadcast.class);
        Join<Broadcast, User> broadcastUserJoin = broadcastRoot.join("user");
        Predicate user = criteriaBuilder.equal(broadcastUserJoin.get("id"), rt);
        criteriaQuery.select(broadcastRoot);
        Order order = criteriaBuilder.desc(broadcastRoot.get("id"));
        criteriaQuery.select(broadcastRoot).where(user).orderBy(new Order[]{order});
        List<Broadcast> broadcastList = this.entityManager.createQuery(criteriaQuery).getResultList();
        return broadcastList;
    }
}

