package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Graindepot;
import com.zhoubi.graindepot.biz.GraindepotBiz;
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
@RequestMapping("graindepot")
public class GraindepotController extends BaseController {
    @Autowired
    private GraindepotBiz graindepotBiz;

    @GetMapping("/list/page")
    public PagerModel graindepotPageList(int start, int length, String graindepotname) {
        PagerModel<Graindepot> e = new PagerModel();
        e.addOrder("graindepotid desc");
        e.setStart(start);
        e.setLength(length);
        if (graindepotname != null) {
            e.putWhere("graindepotname", "%"+graindepotname+"%");
        }
        PagerModel<Graindepot> result = graindepotBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult graindepotEdit(Graindepot item) throws ParseException {

        if (item.getGraindepotid() == null) {
            //新增
            graindepotBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            graindepotBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult graindepotDel(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            graindepotBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String graindepotname, Integer graindepotid,Integer companyid) {
        Map map = new HashMap();
        map.put("graindepotname", graindepotname);
        map.put("graindepotid", graindepotid);
        map.put("companyid", companyid);
        int result = graindepotBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
