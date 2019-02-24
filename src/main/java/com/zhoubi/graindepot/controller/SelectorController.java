package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.bean.*;
import com.zhoubi.graindepot.biz.SelectorBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanghao on 2019/1/16.
 * 下拉框后台请求
 */
@RestController
@RequestMapping("selector")
public class SelectorController extends BaseController {

    @Autowired
    private SelectorBiz selectorBiz;
    //省下拉框
    @GetMapping("provinceList")
    public List<Province> provinceList(HttpServletRequest request){
        Map param=new HashMap();
        List<Province> provinceList=selectorBiz.provinceList(param);
        return provinceList;
    }
    //市州下拉框
    @GetMapping("cityList")
    public List<City> cityList(HttpServletRequest request,@RequestParam Map param){
        List<City> cityList=selectorBiz.cityList(param);
        return cityList;
    }
    //区县下拉框
    @GetMapping("countyList")
    public List<County> countyList(HttpServletRequest request,@RequestParam Map param){
        List<County> countyList=selectorBiz.countyList(param);
        return countyList;
    }
    //集团下拉框
    @GetMapping("groupList")
    public List<Group> groupList(HttpServletRequest request,@RequestParam Map param){
        List<Group> groupList=selectorBiz.groupList(param);
        return groupList;
    }
    //企业下拉框
    @GetMapping("companyList")
    public List<Company> companyList(HttpServletRequest request,@RequestParam Map param) {
        List<Company> resultList = selectorBiz.companyList(param);
        return resultList;

    }
    //粮库下拉框
    @GetMapping("graindepotList")
    public List<Graindepot> graindepotList(HttpServletRequest request, @RequestParam Map param) {
        List<Graindepot> resultList = selectorBiz.graindepotList(param);
        return resultList;

    }
    //仓房下拉框
    @GetMapping("storageList")
    public List<Storage> storageList(HttpServletRequest request, @RequestParam Map param) {
        if (param.get("graindepotid") != null) {
            param.put("graindepotid", param.get("graindepotid"));
        }else{
            UserAddress ua = getUserAddress();
            if(ua!=null)
                param.put("graindepotid", ua.getGraindepotid());
        }
        List<Storage> resultList = selectorBiz.storageList(param);
        return resultList;

    }
    //粮食品种下拉框
    @GetMapping("grainList")
    public List<Grain> grainList(HttpServletRequest request) {
        Map param = new HashMap();
        List<Grain> resultList = selectorBiz.grainList(param);
        return resultList;

    }

    //粮食性质下拉框
    @GetMapping("grainattrList")
    public List<Grainattr> grainattrList(HttpServletRequest request) {
        Map param = new HashMap();
        List<Grainattr> resultList = selectorBiz.grainattrList(param);
        return resultList;

    }

    //往来单位下拉框
    @GetMapping("traderList")
    public List<Trader> traderList(HttpServletRequest request) {
        UserAddress ua = getUserAddress();
        Map param = new HashMap();
        param.put("graindepotid",ua.getGraindepotid());
        List<Trader> resultList = selectorBiz.traderList(param);
        return resultList;

    }

    //合同类型下拉框
    @GetMapping("contracttypeList")
    public List<Contracttype> contracttypeList(HttpServletRequest request,Integer buysellflag) {
        Map param = new HashMap();
        if (buysellflag!=null) {
            param.put("buysellflag",buysellflag);
        }
        List<Contracttype> resultList = selectorBiz.contracttypeList(param);
        return resultList;

    }
    //仓房结构下拉框
    @GetMapping("storagestructureList")
    public List<Storagestructure> storagestructureList(HttpServletRequest request) {
        Map param = new HashMap();
        List<Storagestructure> resultList = selectorBiz.storagestructureList(param);
        return resultList;

    }
    //仓房类型下拉框
    @GetMapping("storagetypeList")
    public List<Storagetype> storagetypeList(HttpServletRequest request) {
        Map param = new HashMap();
        List<Storagetype> resultList = selectorBiz.storagetypeList(param);
        return resultList;

    }
    //结算方式下拉框
    @GetMapping("settleList")
    public List<Settle> settleList(HttpServletRequest request) {
        Map param = new HashMap();
        List<Settle> resultList = selectorBiz.settleList(param);
        return resultList;

    }
    //账户下拉框
    @GetMapping("accountList")
    public List<Account> accountList(HttpServletRequest request) {
        UserAddress ua = getUserAddress();
        Map param = new HashMap();
        param.put("graindepotid",ua.getGraindepotid());
        List<Account> resultList = selectorBiz.accountList(param);
        return resultList;

    }
    //菜单下拉框
    @GetMapping("menuList")
    public List<BaseMenu> menuList(HttpServletRequest request) {
        UserAddress ua = getUserAddress();
        Map param = new HashMap();
        List<BaseMenu> resultList = selectorBiz.menuList(param);
        return resultList;
    }
    //用户组下拉框
    @GetMapping("ugroupList")
    public List<BaseUgroup> ugroupList(HttpServletRequest request) {
        UserAddress ua = getUserAddress();
        Map param = new HashMap();
        List<BaseUgroup> resultList = selectorBiz.ugroupList(param);
        return resultList;
    }

}
