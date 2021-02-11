package com.restapi.restiwak.dao.impl;

import com.restapi.restiwak.dao.TransaksiIuranDao;
import com.restapi.restiwak.pojo.IuranPerbulan;
import com.restapi.restiwak.pojo.TransaksiIuran;
import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.pojo.convert.TransaksiIuranConvert;
import com.restapi.restiwak.util.ParsingManyToMany;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class TransaksiIuranDaoImpl implements TransaksiIuranDao {
    @PersistenceContext
    EntityManager entityManager;

    public TransaksiIuranDaoImpl() {
    }

    public List<TransaksiIuranConvert> transaksiIuranConvertListByRt(String rt) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<TransaksiIuran> criteriaQuery = criteriaBuilder.createQuery(TransaksiIuran.class);
        Root<TransaksiIuran> root = criteriaQuery.from(TransaksiIuran.class);
        Join<TransaksiIuran, User> joinUser = root.join("user");
        Join<TransaksiIuran, IuranPerbulan> joinPerbulan = root.join("iuranPerbulan");
        Predicate idRt = criteriaBuilder.equal(root.get("idRt"), rt);
        criteriaQuery.select(root);
        Order order = criteriaBuilder.desc(root.get("id"));
        criteriaQuery.select(root).where(idRt).orderBy(new Order[]{order});
        List<TransaksiIuran> result = this.entityManager.createQuery(criteriaQuery).getResultList();
        if (result.size() <= 0) {
            return new ArrayList();
        } else {
            List<TransaksiIuranConvert> iuranConvertList = new ArrayList();
            Iterator var11 = result.iterator();

            while(var11.hasNext()) {
                TransaksiIuran iuran = (TransaksiIuran)var11.next();
                TransaksiIuranConvert convert = new TransaksiIuranConvert();
                convert.setActive(iuran.getActive());
                convert.setId(iuran.getId());
                convert.setTanggalIuran(iuran.getTanggalIuran());
                convert.setTanggalBayar(iuran.getTanggalBayar());
                convert.setUser(iuran.getUser());
                convert.setIdRt(iuran.getIdRt());
                convert.setJmliuranPerbulan(ParsingManyToMany.hitungJmlBayarIuran(iuran.getIuranPerbulan().getJenisIurans()));
                iuranConvertList.add(convert);
            }

            return iuranConvertList;
        }
    }

    public List<TransaksiIuranConvert> transaksiIuranConvertListByUser(String id) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<TransaksiIuran> criteriaQuery = criteriaBuilder.createQuery(TransaksiIuran.class);
        Root<TransaksiIuran> root = criteriaQuery.from(TransaksiIuran.class);
        Join<TransaksiIuran, User> joinUser = root.join("user");
        Join<TransaksiIuran, IuranPerbulan> joinPerbulan = root.join("iuranPerbulan");
        Predicate user = criteriaBuilder.equal(joinUser.get("id"), id);
        criteriaQuery.select(root);
        Order order = criteriaBuilder.desc(root.get("id"));
        criteriaQuery.select(root).where(user).orderBy(new Order[]{order});
        List<TransaksiIuran> result = this.entityManager.createQuery(criteriaQuery).getResultList();
        if (result.size() <= 0) {
            return new ArrayList();
        } else {
            List<TransaksiIuranConvert> iuranConvertList = new ArrayList();
            Iterator var11 = result.iterator();

            while(var11.hasNext()) {
                TransaksiIuran iuran = (TransaksiIuran)var11.next();
                TransaksiIuranConvert convert = new TransaksiIuranConvert();
                convert.setActive(iuran.getActive());
                convert.setId(iuran.getId());
                convert.setTanggalIuran(iuran.getTanggalIuran());
                convert.setTanggalBayar(iuran.getTanggalBayar());
                convert.setUser(iuran.getUser());
                convert.setIdRt(iuran.getIdRt());
                convert.setJmliuranPerbulan(ParsingManyToMany.hitungJmlBayarIuran(iuran.getIuranPerbulan().getJenisIurans()));
                iuranConvertList.add(convert);
            }

            return iuranConvertList;
        }
    }
}