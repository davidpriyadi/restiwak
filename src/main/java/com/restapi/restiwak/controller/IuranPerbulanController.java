package com.restapi.restiwak.controller;

import com.restapi.restiwak.pojo.IuranPerbulan;
import com.restapi.restiwak.pojo.convert.IuranPerbulanConvert;
import com.restapi.restiwak.service.IuranPerbulanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IuranPerbulanController {
    @Autowired
    private IuranPerbulanService iuranPerbulanService;

    public IuranPerbulanController() {
    }

    @GetMapping({"/iuran"})
    public List<IuranPerbulan> iuranPerbulanList() {
        return this.iuranPerbulanService.iuranPerbulanList();
    }

    @GetMapping({"/iuran/{rt}"})
    public List<IuranPerbulanConvert> iuranPerbulanListRT(@PathVariable("rt") String rt) {
        return this.iuranPerbulanService.perbulanConvertListRT(rt);
    }
}