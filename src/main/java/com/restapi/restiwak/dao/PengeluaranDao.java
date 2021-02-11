package com.restapi.restiwak.dao;

import com.restapi.restiwak.pojo.Pengeluaran;
import com.restapi.restiwak.pojo.User;
import com.restapi.restiwak.pojo.convert.PengeluaranConvert;

import java.util.List;

public interface PengeluaranDao {
    List<Pengeluaran> pengeluaranByRt(User user);

    List<Pengeluaran> pengeluaranByRt(String rt);

    List<PengeluaranConvert> pengeluaranConvertList(String rt);
}
