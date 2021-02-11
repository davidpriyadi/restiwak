package com.restapi.restiwak.dao.impl;

import com.restapi.restiwak.dao.IuranPerbulanDao;
import com.restapi.restiwak.pojo.IuranPerbulan;
import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.pojo.convert.IuranPerbulanConvert;
import com.restapi.restiwak.util.ParsingManyToMany;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class IuranPerbulanDaoImpl implements IuranPerbulanDao {
    @PersistenceContext
    EntityManager entityManager;

    public IuranPerbulanDaoImpl() {
    }

    public List<IuranPerbulanConvert> iuranPerbulanConvertList(String rt) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<IuranPerbulan> criteriaQuery = criteriaBuilder.createQuery(IuranPerbulan.class);
        Root<IuranPerbulan> root = criteriaQuery.from(IuranPerbulan.class);
        Join<IuranPerbulan, User> iuranPerbulanUserJoin = root.join("user");
        Predicate user = criteriaBuilder.equal(iuranPerbulanUserJoin.get("id"), rt);
        criteriaQuery.select(root);
        Order order = criteriaBuilder.desc(root.get("id"));
        criteriaQuery.where(user).orderBy(new Order[]{order});
        List<IuranPerbulan> iuranPerbulanList = this.entityManager.createQuery(criteriaQuery).getResultList();
        if (iuranPerbulanList.size() <= 0) {
            return new ArrayList();
        } else {
            List<IuranPerbulanConvert> perbulanConvertList = new ArrayList();
            Iterator var10 = iuranPerbulanList.iterator();

            while(var10.hasNext()) {
                IuranPerbulan perbulan = (IuranPerbulan)var10.next();
                IuranPerbulanConvert convert = new IuranPerbulanConvert();
                convert.setId(perbulan.getId());
                convert.setTanggalIuran(perbulan.getTanggalIuran());
                convert.setUser(perbulan.getUser());
                convert.setJenisIurans(ParsingManyToMany.jenisIuranConvertList(perbulan.getJenisIurans()));
                perbulanConvertList.add(convert);
            }

            return perbulanConvertList;
        }
    }
}
