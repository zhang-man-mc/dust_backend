package com.flightfeather.monitor.service;

import com.flightfeather.monitor.pojo.PageBean;
import com.flightfeather.monitor.pojo.OriginalData;

import java.time.LocalDate;
import java.util.List;


public interface SqlService {

    PageBean page(Integer page, Integer pageSize, String shopname, LocalDate begin, LocalDate end);

    List<OriginalData> show_all();

    List<OriginalData> findShop(String shopname);


    List<OriginalData> findDate(LocalDate begin, LocalDate end);

    List<OriginalData> findByForm(String name, String number, String dname, String begin, String end);
}
