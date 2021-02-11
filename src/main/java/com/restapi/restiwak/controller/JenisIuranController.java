package com.restapi.restiwak.controller;

import com.restapi.restiwak.dao.JenisIuranDao;
import com.restapi.restiwak.pojo.JenisIuran;
import com.restapi.restiwak.pojo.convert.JenisIuranConvert;
import com.restapi.restiwak.service.JenisIuranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JenisIuranController {
    @Autowired
    private JenisIuranDao jenisIuranDao;
    @Autowired
    private JenisIuranService jenisIuranService;

    public JenisIuranController() {
    }

    @GetMapping({"/jenisiuran/{rt}"})
    public List<JenisIuranConvert> jenisIuransByRt(@PathVariable("rt") String rt) {
        return this.jenisIuranDao.jenisIuransByRt(rt);
    }

    @PostMapping({"/jenisiuran/save"})
    public ResponseEntity<Object> saveJenisIuranResponseEntity(@RequestBody JenisIuran jenisIuran) {
        return this.jenisIuranService.createJenisIuran(jenisIuran);
    }

    @DeleteMapping({"/jenisiuran/delete/{id}"})
    public void deleteResponseEntity(@PathVariable("id") Integer id) {
        this.jenisIuranService.deleteJenisIuran(id);
    }
}
