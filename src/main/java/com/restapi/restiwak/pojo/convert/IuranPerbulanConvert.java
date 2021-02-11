package com.restapi.restiwak.pojo.convert;

import com.restapi.restiwak.pojo.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IuranPerbulanConvert {
    private Integer id;
    private LocalDate tanggalIuran;
    private User user;
    private List<JenisIuranConvert> jenisIurans;
}
