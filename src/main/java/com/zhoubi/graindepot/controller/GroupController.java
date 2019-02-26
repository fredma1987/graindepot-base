package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.base.PagerModel;
import com.zhoubi.graindepot.bean.Group;
import com.zhoubi.graindepot.biz.GroupBiz;
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
@RequestMapping("group")
public class GroupController extends BaseController {
    @Autowired
    private GroupBiz groupBiz;

    @GetMapping("/list/page")
    public PagerModel groupPageList(int start, int length, String groupname) {
        PagerModel<Group> e = new PagerModel();
        e.addOrder("groupid desc");
        e.setStart(start);
        e.setLength(length);
        if (groupname != null) {
            e.putWhere("groupname", "%"+groupname+"%");
        }
        PagerModel<Group> result = groupBiz.selectListByPage(e);
        return result;
    }

    @PostMapping("/edit")
    public JsonResult groupEdit(Group item) throws ParseException {

        if (item.getGroupid() == null) {
            //新增
            groupBiz.insert(item);
            return new JsonResult("添加成功", true);
        } else {
            //修改
            groupBiz.update(item);
            return new JsonResult("修改成功", true);
        }

    }

    @PostMapping("/del")
    public JsonResult groupDel(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            Map map = new HashMap();
            map.put("Where_IdsStr", ids);
            groupBiz.deleteMap(map);
        }
        return new JsonResult("删除成功", true);
    }

    @PostMapping("/checkRepeat")
    public String checkRepeat(String groupname, Integer groupid) {
        Map map = new HashMap();
        map.put("groupname", groupname);
        map.put("groupid", groupid);
        int result = groupBiz.checkRepeat(map);
        if (result == 0) {
            return "{\"valid\":true}";
        } else {
            return "{\"valid\":false}";
        }

    }


}
