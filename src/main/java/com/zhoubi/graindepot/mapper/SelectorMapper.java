package com.zhoubi.graindepot.mapper;

import com.zhoubi.graindepot.bean.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhanghao on 2019/1/16.
 */
public interface SelectorMapper {

    List<Province> provinceList(Map param);

    List<City> cityList(Map param);

    List<County> countyList(Map param);

    List<Group> groupList(Map param);

    List<Company> companyList(Map map);

    List<Graindepot> graindepotList(Map map);

    List<Grain> grainList(Map param);

    List<Grainattr> grainattrList(Map param);

    List<Trader> traderList(Map param);

    List<Contracttype> contracttypeList(Map param);

    List<Storagestructure> storagestructureList(Map param);

    List<Storagetype> storagetypeList(Map param);

    List<Storage> storageList(Map param);
    List<Settle> settleList(Map param);

    List<Account> accountList(Map param);

    List<BaseMenu> menuList(Map param);

    List<BaseUgroup> ugroupList(Map param);
    List<Equiptype> equiptypeList(Map param);

    List<Drugkind> drugkindList(Map param);
    List<PlanfileOutplan> outplanList(Map param);
    List<Drug> drugList(Map param);

    List<Truck> trucknumList(Map param);

    List<BaseUser> baseUserList(Map param);
}
