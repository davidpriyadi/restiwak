package com.restapi.restiwak.util;

import com.restapi.restiwak.pojo.JenisIuran;
import com.restapi.restiwak.pojo.convert.JenisIuranConvert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParsingManyToMany {
    public ParsingManyToMany() {
    }

    public static List<JenisIuranConvert> jenisIuranConvertList(List<JenisIuran> jenisIurans) {
        List<JenisIuranConvert> jenisIuranConverts = new ArrayList();
        Iterator var2 = jenisIurans.iterator();

        while(var2.hasNext()) {
            JenisIuran perbulan = (JenisIuran)var2.next();
            JenisIuranConvert convert = new JenisIuranConvert();
            convert.setId(perbulan.getId());
            convert.setNamaIuran(perbulan.getNamaIuran());
            convert.setUser(perbulan.getUser());
            convert.setNominal(perbulan.getNominal());
            jenisIuranConverts.add(convert);
        }

        return jenisIuranConverts;
    }

    public static int hitungJmlBayarIuran(List<JenisIuran> jenisIurans) {
        int total = 0;
        int jenisIuran = 0;

        for (JenisIuran iuran : jenisIurans){
           total = jenisIuran + Math.addExact(jenisIuran,iuran.getNominal());
        }
        return total;
    }
}
