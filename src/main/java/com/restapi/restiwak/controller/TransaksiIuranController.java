package com.restapi.restiwak.controller;

import com.restapi.restiwak.pojo.TransaksiIuran;
import com.restapi.restiwak.pojo.convert.TransaksiIuranConvert;
import com.restapi.restiwak.service.TransaksiIuranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransaksiIuranController {
    @Autowired
    private TransaksiIuranService transaksiIuranService;

    public TransaksiIuranController() {
    }

    @GetMapping({"/transaksi/{rt}"})
    public List<TransaksiIuranConvert> transaksiIuranConvertsByRT(@PathVariable("rt") String rt) {
        return this.transaksiIuranService.perbulanConvertListByRt(rt);
    }

    @GetMapping({"/transaksi/user/{user}"})
    public List<TransaksiIuranConvert> transaksiIuranConvertsByUser(@PathVariable("user") String user) {
        return this.transaksiIuranService.transaksiIuranConvertsByUser(user);
    }

    @PostMapping({"/transaksi/save"})
    public ResponseEntity<TransaksiIuran> creatTransaksiIuranResponseEntity(@RequestBody TransaksiIuran transaksiIuran) {
        TransaksiIuran iuran = this.transaksiIuranService.generateTransaksi(transaksiIuran);
        return new ResponseEntity(iuran, HttpStatus.CREATED);
    }

    @PostMapping({"/transaksi/save/all"})
    public List<TransaksiIuran> createAllIurans(@RequestBody List<TransaksiIuran> transaksiIurans) {
        List<TransaksiIuran> list = this.transaksiIuranService.generateAll(transaksiIurans);
        return list;
    }

    @PutMapping({"/transaksi/update"})
    ResponseEntity<TransaksiIuran> updateIuranResponseEntity(@RequestBody TransaksiIuran transaksiIuran) {
        TransaksiIuran iuran = this.transaksiIuranService.generateTransaksi(transaksiIuran);
        return new ResponseEntity(iuran, HttpStatus.CREATED);
    }
}

