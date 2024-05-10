package com.flightfeather.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    private String uiGuid;
    private String uiHeadIconUrl;
    private String uiAccountName;
    private String uiRealName;
    private String uiPassword;
    private String uiUserTypeID;
    private String uiUserType;
    private String uiUserSubTypeId;
    private String uiUserSubType;
    private String dGuid;
    private String uiDepartmentName;
    private String uiIsEnable;
    private String uiWorkNo;
    private String uiTelephone;
    private String uiWechatID;
    private String uiCreateTime;
    private String uiLoginTime;
    private String uiExtension1;
    private String uiExtension2;
    private String uiExtension3;
    private String uiRemark;

}
