package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Storage;
import com.zhoubi.graindepot.biz.StorageBiz;
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
@RequestMapping("storage")
public class StorageController extends BaseController {
    @Autowired
    private StorageBiz storageBiz;

    @GetMapping("/list/page")
    public PagerModel storagePageList(int start, int length, String storagename) {
        PagerModel<Storage> e = new PagerModel();
        e.addOrder("orderno desc");
        e.setStart(start);
        e.setLength(length);
        if (storagename != null) {
            e.putWhere("storagename", "%"+storagename+"%");
        }
        PagerModel<Storage> result = storageBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult storageEdit(Storage item) throws ParseException {

        if (item.getStorageid() == null) {
            //新增
            storageBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            storageBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult storageDel(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            storageBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String storagename, Integer storageid,Integer graindepotid) {
        Map map = new HashMap();
        map.put("storagename", storagename);
        map.put("storageid", storageid);
        map.put("graindepotid", graindepotid);
        int result = storageBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
