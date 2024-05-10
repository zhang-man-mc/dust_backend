package com.flightfeather.monitor.mapper;

import com.flightfeather.monitor.pojo.AnalysisData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnalysisDataMapper {

    @Select("select * from analysis_data")
    List<AnalysisData> findAllData();

    List<AnalysisData> findByDevId(String devId, String begin, String end);


    List<AnalysisData> find(String shopname, String value, String begin, String end);

    @Insert("insert into fm_web_analysis_data values(#{fumeDevId},#{fumeDate},#{fumeDayMin},#{fumeDayMax},#{fumeDayAverage},#{purifierOpenRate},#{fumeMinuteExceedingNum},#{fumeOverStandardRate},#{fumeDataEfficiency},#{dailyOnlineRate},#{noonOnlineRate},#{nightOnlineRate},#{keyOnlineRate},#{noonValidRate},#{nightValidRate},#{keyValidRate},#{noonOpeningCount},#{nightOpeningCount},#{keyOpeningRate},#{noonExceedingNum},#{nightExceedingNum},#{keyExceedingRate})")
    void write(AnalysisData analysisData);

    List<AnalysisData> search(String shopname, String value, String begin, String end);

}
