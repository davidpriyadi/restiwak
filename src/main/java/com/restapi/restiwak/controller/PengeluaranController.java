package com.restapi.restiwak.controller;

import com.restapi.restiwak.dao.PengeluaranDao;
import com.restapi.restiwak.pojo.Pengeluaran;
import com.restapi.restiwak.service.PengeluaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PengeluaranController {
    @Autowired
    private PengeluaranDao pengeluaranDao;
    @Autowired
    private PengeluaranService pengeluaranService;

    public PengeluaranController() {
    }

    @GetMapping({"/pengeluaran/{rt}"})
    public List<Pengeluaran> getAllEmployessById(@PathVariable("rt") String rt) {
        return this.pengeluaranDao.pengeluaranByRt(rt);
    }

    @PostMapping({"/pengeluaran/save"})
    public ResponseEntity<Pengeluaran> savePengeluaranResponseEntity(@RequestBody Pengeluaran pengeluaran) {
        Pengeluaran newPengeluaran = this.pengeluaranService.save(pengeluaran);
        return new ResponseEntity(newPengeluaran, HttpStatus.CREATED);
    }

    @PutMapping({"/pengeluaran/update"})
    public void update(@RequestBody Pengeluaran pengeluaran) {
        this.pengeluaranService.updatePengeluaran(pengeluaran);
    }

    @DeleteMapping({"/pengeluaran/delete/{id}"})
    public void delete(@PathVariable("id") Integer id) {
        this.pengeluaranService.delete(id);
    }
}
