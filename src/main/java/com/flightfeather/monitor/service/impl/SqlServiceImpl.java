package com.flightfeather.monitor.service.impl;

import com.flightfeather.monitor.mapper.SqlMapper;
import com.flightfeather.monitor.pojo.OriginalData;
import com.flightfeather.monitor.pojo.PageBean;
import com.flightfeather.monitor.service.SqlService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class SqlServiceImpl implements SqlService {
    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String shopname, LocalDate begin, LocalDate end) {
        /* //获取总记录数
        Long count=empMapper.count();
        //获取分页查询结果列表
        Integer start =(page-1)*pageSize;
        List<Emp> list=empMapper.list(start,pageSize);*/
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<OriginalData> infoList = sqlMapper.list(shopname, begin, end);
        //获取查询结果
        Page<OriginalData> p1 = (Page<OriginalData>) infoList;

        //封装PageBean对象*/
        PageBean pageBean = new PageBean(p1.getTotal(), p1.getResult());
        return pageBean;

    }

    @Override
    public List<OriginalData> show_all() {
        List<OriginalData> list_sql = sqlMapper.show_all();
        return list_sql;
    }

    @Override
    public List<OriginalData> findShop(String shopname) {
        List<OriginalData> shops = sqlMapper.findShop(shopname);
        return shops;
    }

    @Override
    public List<OriginalData> findDate(LocalDate begin, LocalDate end) {
        List<OriginalData> dates = sqlMapper.findDate(begin, end);
        return dates;
    }

    @Override
    public List<OriginalData> findByForm(String name, String number, String dname, String begin, String end) {
        List<OriginalData> form = sqlMapper.findByForm(name, number, dname, begin, end);
        return form;
    }


}
