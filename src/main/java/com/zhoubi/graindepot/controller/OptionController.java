package com.zhoubi.graindepot.controller;

import com.alibaba.fastjson.JSONArray;
import com.zhoubi.graindepot.base.JsonResult;
import com.zhoubi.graindepot.bean.Option;
import com.zhoubi.graindepot.bean.UserAddress;
import com.zhoubi.graindepot.biz.OptionBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("option")
public class OptionController extends BaseController{
    @Autowired
    private OptionBiz optionBiz;

    @GetMapping("one/{optioncode}")
    @ResponseBody
    public JsonResult option_one(@PathVariable("optioncode") String optioncode){
        UserAddress ua=getUserAddress();
        Map param=new HashMap();
        param.put("optioncode",optioncode);
        param.put("graindepotid",ua.getGraindepotid());
        Option option = optionBiz.selectOne(param);
        //如果没有则找默认值标准
        if (option==null) {
            param.clear();
            param.put("optioncode",optioncode);
            Option defaultOption = optionBiz.getDefaultOption(param);
            return new JsonResult(defaultOption,true);
        }

        return new JsonResult(option,true);
    }

    @GetMapping("getOptions")
    @ResponseBody
    public JsonResult getOptions(){
        UserAddress ua=getUserAddress();
        Map param=new HashMap();
        param.put("graindepotid",ua.getGraindepotid());
        List<Option> options = optionBiz.getOptions(param);
        return new JsonResult(options,"查询成功",true);
    }

    @PostMapping("saveOption")
    @ResponseBody
    public JsonResult saveOption(String listStr){
        UserAddress ua=getUserAddress();
        List<Option> options = JSONArray.parseArray(listStr, Option.class);
        Map map=new HashMap();
        for (Option option:options) {
            map.clear();
            map.put("Where_graindepotid",ua.getGraindepotid());
            map.put("Where_optioncode",option.getOptioncode());
            map.put("optionvalue",option.getOptionvalue());
            int i = optionBiz.updateMap(map);
            if (i==0) {
                Option item=new Option();
                item.setOptioncode(option.getOptioncode());
                item.setOptionvalue(option.getOptionvalue());
                item.setGroupid(ua.getGroupid());
                item.setCompanyid(ua.getCompanyid());
                item.setGraindepotid(ua.getGraindepotid());
                optionBiz.insert(item);
            }
        }
        return new JsonResult("修改成功",true);
    }
}
