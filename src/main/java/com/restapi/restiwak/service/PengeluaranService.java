package com.restapi.restiwak.service;

import com.restapi.restiwak.pojo.Pengeluaran;
import com.restapi.restiwak.repo.PengeluaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PengeluaranService {
    @Autowired
    private PengeluaranRepository pengeluaranRepository;

    public PengeluaranService() {
    }

    public List<Pengeluaran> pengeluaranList() {
        return this.pengeluaranRepository.findAll();
    }

    public Pengeluaran save(Pengeluaran pengeluaran) {
        return (Pengeluaran)this.pengeluaranRepository.save(pengeluaran);
    }

    public void delete(Integer id) {
        this.pengeluaranRepository.deleteById(id);
    }

    public void updatePengeluaran(Pengeluaran pengeluaran) {
        this.pengeluaranRepository.save(pengeluaran);
    }
}
