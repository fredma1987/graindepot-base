package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Authority;
import com.zhoubi.graindepot.bean.BaseUser;
import com.zhoubi.graindepot.bean.UserAddress;
import com.zhoubi.graindepot.biz.AuthorityBiz;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("authority")
public class AuthorityController extends BaseController {
    @Autowired
    private AuthorityBiz authorityBiz;

    @GetMapping("/list/page")
    public PagerModel graindepotPageList(int start, int length, String authoritycode) {
        UserAddress ua = getUserAddress();
        PagerModel<Authority> e = new PagerModel();
        e.addOrder("authoritytime desc");
        e.setStart(start);
        e.setLength(length);
        e.putWhere("graindepotid",ua.getGraindepotid());
        e.putWhere("authoritycode", authoritycode);
        PagerModel<Authority> result = authorityBiz.selectListByPage(e);
        return result;
    }

    //获取用户列表
    @GetMapping("user/list")
    public List<BaseUser> user_list(){
        UserAddress ua=getUserAddress();
        Map map=new HashMap();
        map.put("graindepotid",ua.getGraindepotid());
        List<BaseUser> userList = authorityBiz.getUserList(map);
        return userList;
    }

    @PostMapping("save")
    public JsonResult save(Authority item) throws ParseException {
        BaseUser user=getCurrentUser();
        UserAddress ua=getUserAddress();
        String authoritybeginstr=item.getAuthoritybeginstr();
        if (StringUtils.isNotEmpty(authoritybeginstr)) {
            item.setAuthoritybegin(DateUtils.parseDate(authoritybeginstr,"yyyy-MM-dd HH:mm"));
        }
        String authorityendstr=item.getAuthorityendstr();
        if (StringUtils.isNotEmpty(authorityendstr)) {
            item.setAuthorityend(DateUtils.parseDate(authorityendstr,"yyyy-MM-dd HH:mm"));
        }
        item.setGroupid(ua.getGroupid());
        item.setCompanyid(ua.getCompanyid());
        item.setGraindepotid(ua.getGraindepotid());
        item.setFromuserid(user.getUserid());
        item.setAuthoritytime(new Date());
        item.setIsclose(0);
        authorityBiz.insert(item);
        return new JsonResult("添加成功",true);
    }

}
