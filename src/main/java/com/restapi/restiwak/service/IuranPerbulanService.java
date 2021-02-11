package com.restapi.restiwak.service;

import com.restapi.restiwak.dao.IuranPerbulanDao;
import com.restapi.restiwak.pojo.IuranPerbulan;
import com.restapi.restiwak.pojo.convert.IuranPerbulanConvert;
import com.restapi.restiwak.repo.IuranPerbulanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IuranPerbulanService {
    @Autowired
    private IuranPerbulanRepository perbulanRepository;
    @Autowired
    private IuranPerbulanDao iuranPerbulanDao;

    public IuranPerbulanService() {
    }

    public List<IuranPerbulan> iuranPerbulanList() {
        return this.perbulanRepository.findAll();
    }

    public List<IuranPerbulanConvert> perbulanConvertListRT(String rt) {
        return this.iuranPerbulanDao.iuranPerbulanConvertList(rt);
    }
}
