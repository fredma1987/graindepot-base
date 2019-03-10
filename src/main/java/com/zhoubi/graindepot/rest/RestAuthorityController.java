package com.zhoubi.graindepot.rest;

import com.zhoubi.graindepot.bean.BaseUser;
import com.zhoubi.graindepot.bean.UserAddress;
import com.zhoubi.graindepot.biz.AuthorityBiz;
import com.zhoubi.graindepot.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/16/016.
 */
@Controller
@RequestMapping("rpc")
public class RestAuthorityController extends BaseController{
    @Autowired
    private AuthorityBiz authorityBiz;
    //查询是否有权限
    @RequestMapping(value = "/authority/isAllow", method = RequestMethod.GET)
    @ResponseBody
    public boolean authority_isAllow(String  authoritycode){
        Map param=new HashMap();
        UserAddress ua=getUserAddress();
        BaseUser user=getCurrentUser();
        param.put("authoritycode",authoritycode);
        param.put("graindepotid",ua.getGraindepotid());
        param.put("touserid",user.getUserid());
        boolean allow = authorityBiz.isAllow(param);
        return allow;
    }

}
