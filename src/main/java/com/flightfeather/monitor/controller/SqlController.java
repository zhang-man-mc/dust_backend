package com.flightfeather.monitor.controller;

import com.flightfeather.monitor.pojo.PageBean;
import com.flightfeather.monitor.pojo.Result;
import com.flightfeather.monitor.pojo.OriginalData;
import com.flightfeather.monitor.service.SqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/web")
@CrossOrigin
public class SqlController {
    @Autowired
    private SqlService sqlService;

    @GetMapping("/findall")
    public Result show_all(){
        log.info("打印数据库所有信息");
        List<OriginalData> list_sql=sqlService.show_all();
        return Result.success(list_sql);
    }

    @GetMapping("/shopname/{shopname}")
    public Result findByShop(@PathVariable String shopname){
        log.info("查找{}的信息",shopname);
        List<OriginalData> shops=sqlService.findShop(shopname);
        return Result.success(shops);
    }




    //表单条件查询
    @GetMapping("/form")
    public Result findByForm( String name, String dname, String number, String begin, String end) throws ParseException {
        if(begin!=null &&end!=null) {
            log.info("begin:{},end:{}", begin, end);
            String begin1 = begin + " 00:00:00";
            String end1 = end + " 00:00:00";
            log.info("begin:{},end:{}", begin1, end1);
        }

       String begin1=begin;
       String end1=end;

        //调用业务层分页查询功能
        List<OriginalData> form= sqlService.findByForm(name,number,dname,begin1,end1);
        return Result.success(form);
    }



    @GetMapping("/tiaojian")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "20")Integer pageSize,    //pageSize:10，20，50，100
                       String shopname,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询,参数是：{},{}",page,pageSize);
        //调用业务层分页查询功能
        PageBean pageBean = sqlService.page(page,pageSize,shopname,begin,end);
        return Result.success(pageBean);
    }



}
