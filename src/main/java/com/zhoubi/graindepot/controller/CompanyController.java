package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Company;
import com.zhoubi.graindepot.biz.CompanyBiz;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1A12 on 2019/1/19/0019.
 */
@RestController
@RequestMapping("company")
public class CompanyController extends BaseController {
    @Autowired
    private CompanyBiz companyBiz;

    @GetMapping("/list/page")
    public PagerModel companyPageList(int start, int length, String companyname) {
        PagerModel<Company> e = new PagerModel();
        e.addOrder("companyid desc");
        e.setStart(start);
        e.setLength(length);
        if (companyname != null) {
            e.putWhere("companyname", "%"+companyname+"%");
        }
        PagerModel<Company> result = companyBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult companyEdit(Company item) throws ParseException {

        if (item.getCompanyid() == null) {
            //新增
            companyBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            companyBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult companyDel(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            companyBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String companyname, Integer companyid) {
        Map map = new HashMap();
        map.put("companyname", companyname);
        map.put("companyid", companyid);
        int result = companyBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
