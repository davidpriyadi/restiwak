package com.restapi.restiwak.service;

import com.restapi.restiwak.dao.TransaksiIuranDao;
import com.restapi.restiwak.pojo.TransaksiIuran;
import com.restapi.restiwak.pojo.convert.TransaksiIuranConvert;
import com.restapi.restiwak.repo.TransaksiIuranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransaksiIuranService {
    @Autowired
    private TransaksiIuranDao transaksiIuranDao;
    @Autowired
    private TransaksiIuranRepository transaksiIuranRepository;

    public TransaksiIuranService() {
    }

    public List<TransaksiIuranConvert> perbulanConvertListByRt(String rt) {
        return this.transaksiIuranDao.transaksiIuranConvertListByRt(rt);
    }

    public List<TransaksiIuranConvert> transaksiIuranConvertsByUser(String user) {
        return this.transaksiIuranDao.transaksiIuranConvertListByUser(user);
    }

    public TransaksiIuran generateTransaksi(TransaksiIuran transaksiIuran) {
        return (TransaksiIuran)this.transaksiIuranRepository.save(transaksiIuran);
    }

    public List<TransaksiIuran> generateAll(List<TransaksiIuran> transaksiIurans) {
        return this.transaksiIuranRepository.saveAll(transaksiIurans);
    }
}
