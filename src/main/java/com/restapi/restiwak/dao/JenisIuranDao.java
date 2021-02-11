package com.restapi.restiwak.dao;

import com.restapi.restiwak.pojo.convert.JenisIuranConvert;

import java.util.List;

public interface JenisIuranDao {
    List<JenisIuranConvert> jenisIuransByRt(String rt);
}
