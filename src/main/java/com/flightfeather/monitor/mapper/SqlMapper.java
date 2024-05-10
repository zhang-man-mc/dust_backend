package com.flightfeather.monitor.mapper;

import com.flightfeather.monitor.pojo.OriginalData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SqlMapper {


    //查询所有
    @Select("select * from qianduan_sql.ed_data")
    List<OriginalData> show_all();

    //模糊查询
    @Select("select * from qianduan_sql.ed_data where shop_name like concat('%',#{shopname},'%')")
    List<OriginalData> findShop(String shopname);

    //条件查询
    List<OriginalData> list(String shopname, LocalDate begin, LocalDate end);

    @Select("select * from qianduan_sql.ed_data where reporting_time between #{begin} and #{end}")
    List<OriginalData> findDate(LocalDate begin, LocalDate end);

    //表单条件查询
    List<OriginalData> findByForm(String name, String number, String dname, String begin, String end);
}
