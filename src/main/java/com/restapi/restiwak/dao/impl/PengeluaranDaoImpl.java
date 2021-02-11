package com.restapi.restiwak.dao.impl;

import com.restapi.restiwak.dao.PengeluaranDao;
import com.restapi.restiwak.pojo.Pengeluaran;
import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.pojo.convert.PengeluaranConvert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PengeluaranDaoImpl implements PengeluaranDao {
    @PersistenceContext
    EntityManager entityManager;

    public PengeluaranDaoImpl() {
    }

    public List<Pengeluaran> pengeluaranByRt(User user) {
        return null;
    }

    public List<Pengeluaran> pengeluaranByRt(String rt) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Pengeluaran> criteriaQuery = criteriaBuilder.createQuery(Pengeluaran.class);
        Root<Pengeluaran> pengeluaranRoot = criteriaQuery.from(Pengeluaran.class);
        Join<Pengeluaran, User> joinUser = pengeluaranRoot.join("user");
        Predicate user = criteriaBuilder.equal(joinUser.get("id"), rt);
        criteriaQuery.select(pengeluaranRoot);
        Order order = criteriaBuilder.desc(pengeluaranRoot.get("id"));
        criteriaQuery.select(pengeluaranRoot).where(user).orderBy(new Order[]{order});
        List<Pengeluaran> result = this.entityManager.createQuery(criteriaQuery).getResultList();
        return result;
    }

    public List<PengeluaranConvert> pengeluaranConvertList(String rt) {
        return null;
    }
}
