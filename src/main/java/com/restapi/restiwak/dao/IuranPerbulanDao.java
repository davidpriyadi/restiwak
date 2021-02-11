package com.restapi.restiwak.dao;

import com.restapi.restiwak.pojo.convert.IuranPerbulanConvert;

import java.util.List;

public interface IuranPerbulanDao {
    List<IuranPerbulanConvert> iuranPerbulanConvertList(String rt);
}
