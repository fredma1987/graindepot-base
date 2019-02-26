package com.zhoubi.graindepot.controller;

import com.zhoubi.graindepot.bean.*;
import com.zhoubi.graindepot.biz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/2/26/026.
 */
@Controller
@RequestMapping("/page")
public class PageController extends BaseController {
    @Autowired
    private GrainattrBiz grainattrBiz;
    @Autowired
    private GrainBiz grainBiz;
    @Autowired
    private ContracttypeBiz contracttypeBiz;
    @Autowired
    private StoragestructureBiz storagestructureBiz;
    @Autowired
    private StoragetypeBiz storagetypeBiz;
    @Autowired
    private SettleBiz settleBiz;
    @Autowired
    private GroupBiz groupBiz;
    @Autowired
    private CompanyBiz companyBiz;
    @Autowired
    private GraindepotBiz graindepotBiz;
    @Autowired
    private StorageBiz storageBiz;
    //----------------------------------粮食性质---------------------------------------------
    //粮食性质主页
    @GetMapping("/grainattr")
    public String to_grainattr(Model model) {
        String title = "粮食性质";
        model.addAttribute("title", title);
        String path = "grainattr/list";
        return path;
    }

    //粮食性质编辑
    @GetMapping("/grainattr/edit")
    public String to_grainattr_edit(Model model, Integer id) {
        String title = "粮食性质编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Grainattr item = new Grainattr();
        if (id != null) {
            item = grainattrBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "grainattr/edit";
        return path;
    }


    //----------------------------------粮食品种---------------------------------------------
    //粮食品种主页
    @GetMapping("/grain")
    public String to_grain(Model model) {
        String title = "粮食品种";
        model.addAttribute("title", title);
        String path = "grain/list";
        return path;
    }

    //粮食品种编辑
    @GetMapping("/grain/edit")
    public String to_grain_edit(Model model, Integer id) {
        String title = "粮食品种编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Grain item = new Grain();
        if (id != null) {
            item = grainBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "grain/edit";
        return path;
    }

    //----------------------------------合同类型---------------------------------------------
    //合同类型主页
    @GetMapping("/contracttype")
    public String toContracttype(Model model) {
        String title = "合同类型";
        model.addAttribute("title", title);
        String path = "contracttype/list";
        return path;
    }

    //合同类型编辑
    @GetMapping("/contracttype/edit")
    public String to_contracttype_edit(Model model, Integer id) {
        String title = "合同类型编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Contracttype item = new Contracttype();
        if (id != null) {
            item = contracttypeBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "contracttype/edit";
        return path;
    }

    //----------------------------------仓房结构---------------------------------------------
    //仓房结构主页
    @GetMapping("/storagestructure")
    public String to_storagestructure(Model model) {
        String title = "仓房结构";
        model.addAttribute("title", title);
        String path = "storagestructure/list";
        return path;
    }

    //仓房结构编辑
    @GetMapping("/storagestructure/edit")
    public String to_storagestructure_edit(Model model, Integer id) {
        String title = "仓房结构编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Storagestructure item = new Storagestructure();
        if (id != null) {
            item = storagestructureBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "storagestructure/edit";
        return path;
    }
    //----------------------------------仓房类型---------------------------------------------
    //仓房类型主页
    @GetMapping("/storagetype")
    public String to_storagetype(Model model) {
        String title = "仓房结构";
        model.addAttribute("title", title);
        String path = "storagetype/list";
        return path;
    }

    //仓房类型编辑
    @GetMapping("/storagetype/edit")
    public String to_storagetype_edit(Model model, Integer id) {
        String title = "仓房结构编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Storagetype item = new Storagetype();
        if (id != null) {
            item = storagetypeBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "storagetype/edit";
        return path;
    }
    //----------------------------------结算方式---------------------------------------------
    //仓房类型主页
    @GetMapping("/settle")
    public String to_settle(Model model) {
        String title = "结算方式";
        model.addAttribute("title", title);
        String path = "settle/list";
        return path;
    }

    //仓房类型编辑
    @GetMapping("/settle/edit")
    public String to_settle_edit(Model model, Integer id) {
        String title = "结算方式编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Settle item = new Settle();
        if (id != null) {
            item = settleBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "settle/edit";
        return path;
    }
    //----------------------------------集团信息---------------------------------------------
    //集团信息主页
    @GetMapping("/group")
    public String to_group(Model model) {
        String title = "集团信息";
        model.addAttribute("title", title);
        String path = "group/list";
        return path;
    }

    //集团信息编辑
    @GetMapping("/group/edit")
    public String to_group_edit(Model model, Integer id) {
        String title = "集团信息编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Group item = new Group();
        if (id != null) {
            item = groupBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "group/edit";
        return path;
    }
    //----------------------------------企业信息---------------------------------------------
    //企业信息主页
    @GetMapping("/company")
    public String to_company(Model model) {
        String title = "企业信息";
        model.addAttribute("title", title);
        String path = "company/list";
        return path;
    }

    //企业信息编辑
    @GetMapping("/company/edit")
    public String to_company_edit(Model model, Integer id) {
        String title = "企业信息编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Company item = new Company();
        if (id != null) {
            item = companyBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "company/edit";
        return path;
    }
    //----------------------------------粮库信息---------------------------------------------
    //粮库信息主页
    @GetMapping("/graindepot")
    public String to_graindepot(Model model) {
        String title = "粮库信息";
        model.addAttribute("title", title);
        String path = "graindepot/list";
        return path;
    }

    //粮库信息编辑
    @GetMapping("/graindepot/edit")
    public String to_graindepot_edit(Model model, Integer id) {
        String title = "粮库信息编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Graindepot item = new Graindepot();
        if (id != null) {
            item = graindepotBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "graindepot/edit";
        return path;
    }
    //----------------------------------仓房信息---------------------------------------------
    //仓房信息主页
    @GetMapping("/storage")
    public String to_storage(Model model) {
        String title = "仓房信息";
        model.addAttribute("title", title);
        String path = "storage/list";
        return path;
    }

    //仓房信息编辑
    @GetMapping("/storage/edit")
    public String to_storage_edit(Model model, Integer id) {
        String title = "仓房信息编辑";
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        Storage item = new Storage();
        if (id != null) {
            item = storageBiz.selectById(id);
        }
        model.addAttribute("item", item);
        String path = "storage/edit";
        return path;
    }
}
