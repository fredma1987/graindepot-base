package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Grain;
import com.zhoubi.graindepot.bean.Settle;
import com.zhoubi.graindepot.biz.GrainBiz;
import com.zhoubi.graindepot.biz.SettleBiz;
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
@RequestMapping("settle")
public class SettleController extends BaseController {
    @Autowired
    private SettleBiz settleBiz;

    @GetMapping("/list/page")
    public PagerModel pageList(int start, int length, String settlename) {
        PagerModel<Settle> e = new PagerModel();
        e.addOrder("settlecode");
        e.setStart(start);
        e.setLength(length);
        if (settlename != null) {
            e.putWhere("settlename", "%"+settlename+"%");
        }
        PagerModel<Settle> result = settleBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult edit(Settle item) throws ParseException {

        if (item.getSettleid() == null) {
            //新增
            settleBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            settleBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult del(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            settleBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String settlename, Integer settleid) {
        Map map = new HashMap();
        map.put("settlename", settlename);
        map.put("settleid", settleid);
        int result = settleBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
