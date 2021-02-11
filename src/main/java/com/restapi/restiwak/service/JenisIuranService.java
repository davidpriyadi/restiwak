package com.restapi.restiwak.service;

import com.restapi.restiwak.pojo.JenisIuran;
import com.restapi.restiwak.repo.JenisIuranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class JenisIuranService {
    @Autowired
    private JenisIuranRepository jenisIuranRepository;

    public JenisIuranService() {
    }

    public ResponseEntity<Object> createJenisIuran(JenisIuran jenisIuran) {
        JenisIuran iuran = new JenisIuran();
        iuran.setNamaIuran(jenisIuran.getNamaIuran());
        iuran.setId(jenisIuran.getId());
        iuran.setNominal(jenisIuran.getNominal());
        iuran.setUser(jenisIuran.getUser());
        JenisIuran js = (JenisIuran)this.jenisIuranRepository.save(iuran);
        return this.jenisIuranRepository.findById(js.getId()).isPresent() ? ResponseEntity.ok("Jenis Iuran Created Successfull") : ResponseEntity.unprocessableEntity().body("Failed Creating Jenis Iuran as Specified");
    }

    public void addJenisIuran(JenisIuran jenisIuran) {
        this.jenisIuranRepository.save(jenisIuran);
    }

    public JenisIuran updateJenisIuran(JenisIuran jenisIuran) {
        return (JenisIuran)this.jenisIuranRepository.save(jenisIuran);
    }

    public void deleteJenisIuran(Integer id) {
        this.jenisIuranRepository.deleteById(id);
    }
}
