package com.restapi.restiwak.pojo.convert;

import com.restapi.restiwak.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JenisIuranConvert {
    private int id;
    private String namaIuran;
    private int nominal;
    private User user;
}
