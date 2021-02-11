package com.restapi.restiwak.pojo.convert;

import com.restapi.restiwak.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransaksiIuranConvert {
    private Integer id;
    private LocalDate tanggalIuran;
    private User user;
    private int jmliuranPerbulan;
    private LocalDate tanggalBayar;
    private String idRt;
    private Boolean active;

}
