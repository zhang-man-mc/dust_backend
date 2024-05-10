package com.flightfeather.monitor.mapper;

import com.flightfeather.monitor.pojo.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {


    @Select("select * from sm_t_userinfo where UI_AccountName =#{uiAccountName} and UI_Password =#{uiPassword}")
    LoginUser getByUsernameAndPassword(LoginUser loginUser);
}
