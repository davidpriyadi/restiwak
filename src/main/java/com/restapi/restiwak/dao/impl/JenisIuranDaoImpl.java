package com.restapi.restiwak.dao.impl;

import com.restapi.restiwak.dao.JenisIuranDao;
import com.restapi.restiwak.pojo.JenisIuran;
import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.pojo.convert.JenisIuranConvert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class JenisIuranDaoImpl implements JenisIuranDao {
    @PersistenceContext
    EntityManager entityManager;

    public JenisIuranDaoImpl() {
    }

    public List<JenisIuranConvert> jenisIuransByRt(String rt) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<JenisIuran> criteriaQuery = criteriaBuilder.createQuery(JenisIuran.class);
        Root<JenisIuran> jenisIuranRoot = criteriaQuery.from(JenisIuran.class);
        Join<JenisIuran, User> iuranUserJoin = jenisIuranRoot.join("user");
        Predicate user = criteriaBuilder.equal(iuranUserJoin.get("id"), rt);
        criteriaQuery.select(jenisIuranRoot);
        Order order = criteriaBuilder.asc(jenisIuranRoot.get("id"));
        criteriaQuery.where(user).orderBy(new Order[]{order});
        List<JenisIuran> jenisIurans = this.entityManager.createQuery(criteriaQuery).getResultList();
        if (jenisIurans.size() <= 0) {
            return new ArrayList();
        } else {
            List<JenisIuranConvert> jenisIuranConverts = new ArrayList();
            Iterator var10 = jenisIurans.iterator();

            while(var10.hasNext()) {
                JenisIuran iuran = (JenisIuran)var10.next();
                JenisIuranConvert convert = new JenisIuranConvert();
                convert.setId(iuran.getId());
                convert.setNamaIuran(iuran.getNamaIuran());
                convert.setNominal(iuran.getNominal());
                convert.setUser(iuran.getUser());
                jenisIuranConverts.add(convert);
            }

            return jenisIuranConverts;
        }
    }
}