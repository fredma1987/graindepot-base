package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Grainattr;
import com.zhoubi.graindepot.bean.Storagestructure;
import com.zhoubi.graindepot.biz.GrainattrBiz;
import com.zhoubi.graindepot.biz.StoragestructureBiz;
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
@RequestMapping("storagestructure")
public class StorageStructureController extends BaseController {
    @Autowired
    private StoragestructureBiz storagestructureBiz;

    @GetMapping("/list/page")
    public PagerModel storagestructurePageList(int start, int length, String storagestructurename) {
        PagerModel<Storagestructure> e = new PagerModel();
        e.addOrder("orderno desc");
        e.setStart(start);
        e.setLength(length);
        if (storagestructurename != null) {
            e.putWhere("storagestructurename", "%"+storagestructurename+"%");
        }
        PagerModel<Storagestructure> result = storagestructureBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult storagestructureEdit(Storagestructure item) throws ParseException {

        if (item.getStoragestructureid() == null) {
            //新增
            storagestructureBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            storagestructureBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult storagetypeDel(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            storagestructureBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String storagestructurename, Integer storagestructureid) {
        Map map = new HashMap();
        map.put("storagestructurename", storagestructurename);
        map.put("storagestructureid", storagestructureid);
        int result = storagestructureBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
