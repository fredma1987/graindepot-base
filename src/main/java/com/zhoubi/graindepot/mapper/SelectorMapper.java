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
}
