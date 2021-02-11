package com.restapi.restiwak.dao;

import com.restapi.restiwak.pojo.convert.TransaksiIuranConvert;

import java.util.List;

public interface TransaksiIuranDao {
    List<TransaksiIuranConvert> transaksiIuranConvertListByRt(String rt);

    List<TransaksiIuranConvert> transaksiIuranConvertListByUser(String id);
}
