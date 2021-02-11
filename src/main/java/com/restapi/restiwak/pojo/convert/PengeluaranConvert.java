package com.restapi.restiwak.pojo.convert;

import com.restapi.restiwak.pojo.JenisIuran;
import com.restapi.restiwak.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PengeluaranConvert {
    private Integer id;
    private String namaPengeluaran;
    private LocalDate tanggalPengeluaran;
    private int nominal;
    private User user;
    private List<JenisIuran> jenisIurans;
}
