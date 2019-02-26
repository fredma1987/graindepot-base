package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Storagestructure;
import com.zhoubi.graindepot.bean.Storagetype;
import com.zhoubi.graindepot.biz.StoragestructureBiz;
import com.zhoubi.graindepot.biz.StoragetypeBiz;
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
@RequestMapping("storagetype")
public class StorageTypeController extends BaseController {
    @Autowired
    private StoragetypeBiz storagetypeBiz;

    @GetMapping("/list/page")
    public PagerModel storagetypePageList(int start, int length, String storagetypename) {
        PagerModel<Storagetype> e = new PagerModel();
        e.addOrder("orderno desc");
        e.setStart(start);
        e.setLength(length);
        if (storagetypename != null) {
            e.putWhere("storagetypename", "%"+storagetypename+"%");
        }
        PagerModel<Storagetype> result = storagetypeBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult storagetypeEdit(Storagetype item) throws ParseException {

        if (item.getStoragetypeid() == null) {
            //新增
            storagetypeBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            storagetypeBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult storagetypeDel(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            storagetypeBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String storagetypename, Integer storagetypeid) {
        Map map = new HashMap();
        map.put("storagetypename", storagetypename);
        map.put("storagetypeid", storagetypeid);
        int result = storagetypeBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
