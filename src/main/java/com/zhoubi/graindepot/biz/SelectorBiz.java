package com.zhoubi.graindepot.biz;

import com.zhoubi.graindepot.bean.*;
import com.zhoubi.graindepot.mapper.SelectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhanghao on 2019/1/16.
 */
@Service
public class SelectorBiz {
    @Autowired
    private SelectorMapper mapper;

    public List<Province> provinceList(Map param) {
        return mapper.provinceList(param);
    }

    public List<City> cityList(Map param) {
        return mapper.cityList(param);
    }

    public List<County> countyList(Map param) {
        return mapper.countyList(param);
    }

    public List<Group> groupList(Map param) {
        return mapper.groupList(param);
    }

    public List<Company> companyList(Map map) {
        return mapper.companyList(map);
    }


    public List<Graindepot> graindepotList(Map map) {
        return mapper.graindepotList(map);
    }

    public List<Grain> grainList(Map param) {
        return mapper.grainList(param);
    }

    public List<Grainattr> grainattrList(Map param) {
        return mapper.grainattrList(param);
    }

    public List<Trader> traderList(Map param) {
        return mapper.traderList(param);
    }

    public List<Contracttype> contracttypeList(Map param) {
        return mapper.contracttypeList(param);
    }

    public List<Storagestructure> storagestructureList(Map param) {
        return mapper.storagestructureList(param);
    }

    public List<Storagetype> storagetypeList(Map param) {
        return mapper.storagetypeList(param);
    }

    public List<Storage> storageList(Map param) {
        return mapper.storageList(param);
    }

    public List<Settle> settleList(Map param) {
        return mapper.settleList(param);
    }


    public List<Account> accountList(Map param) {
        return mapper.accountList(param);
    }

    public List<BaseMenu> menuList(Map param) {
        return mapper.menuList(param);
    }

    public List<BaseUgroup> ugroupList(Map param) {
        return mapper.ugroupList(param);
    }

    public List<Equiptype> equiptypeList(Map param) {
        return mapper.equiptypeList(param);
    }

    public List<Drugkind> drugkindList(Map param) {
        return mapper.drugkindList(param);
    }

    public List<PlanfileOutplan> outplanList(Map param) {
        return mapper.outplanList(param);
    }

    public List<Drug> drugList(Map param) {
        return mapper.drugList(param);
    }

    public List<Truck> trucknumList(Map param){return mapper.trucknumList(param);}

    public List<BaseUser> baseUserList(Map param){return mapper.baseUserList(param);}
}
