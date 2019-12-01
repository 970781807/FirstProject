package com.zz.demo.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import javax.servlet.http.HttpSession;

public class SendSms {
    static final IAcsClient client = new DefaultAcsClient (DefaultProfile.getProfile ("cn-hangzhou", "LTAI4Fv1D4DwWAUwdsQ2GtL9", "hF5pzuZ0uLCTE23ng5mbYDwcS3O8Xb"));

    public static void send(String phone, HttpSession session) {
        String code = VerifyCodeUtil.generateVerifyCode (6, "0123456789");
        session.setAttribute (phone + "code", code);
        sendCode (phone, code);
    }

    public static void sendCode(String phone, String code) {
        CommonRequest request = new CommonRequest ( );
        request.setMethod (MethodType.POST);
        request.setDomain ("dysmsapi.aliyuncs.com");
        request.setVersion ("2017-05-25");
        request.setAction ("SendSms");
        request.putQueryParameter ("RegionId", "cn-hangzhou");
        request.putQueryParameter ("SignName", "加速度算法");
        request.putQueryParameter ("TemplateCode", "SMS_178766679");
        request.putQueryParameter ("PhoneNumbers", phone);
        request.putQueryParameter ("TemplateParam", "{code:" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse (request);
            System.out.println (response.getData ( ));
        } catch (ServerException e) {
            e.printStackTrace ( );
        } catch (ClientException e) {
            e.printStackTrace ( );
        }
    }

    public static boolean code(String phone, String code, HttpSession session) {
        if (phone != null && code != null) {
            String vcode = (String) session.getAttribute (phone + "code");
            if (vcode != null && vcode.equals (code)) {
                return true;
            }
        }
        return false;
    }
}
