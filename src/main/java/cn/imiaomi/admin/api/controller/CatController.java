package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.ImiaoMao;
import cn.imiaomi.admin.api.pojo.ImiaoResource;
import cn.imiaomi.admin.api.pojo.JsonResult;
import cn.imiaomi.admin.api.service.impl.ImiaoServiceImpl;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cat")
public class CatController {

    @Autowired
    ImiaoResource imiaoResource;
    @Autowired
    private ImiaoServiceImpl imiaoService;

    @PostMapping(value = "/list")
    @RequiresAuthentication
    JsonResult listCats(@RequestBody Map<String, Integer> reqMap) {
        int state = reqMap.getOrDefault("state", 1);
        int page = reqMap.getOrDefault("page", 1);
        int pageSize = reqMap.getOrDefault("pageSize", imiaoResource.getPageSize());

        Page<ImiaoMao> list = imiaoService.listCatsByState(state, page, pageSize);
        JsonResult jsonResult = new JsonResult(200, "ok", list.getResult(), list.getTotal());
        return jsonResult;
    }

    @PostMapping(value = "/detail")
    @RequiresAuthentication
    ImiaoMao getDetail(@RequestParam(defaultValue = "") String id) {
        return imiaoService.getCatById(id);
    }

    /**
     * TODO 删除单个图片记录
     * @param imiaoMao
     * @return
     */
    @PostMapping(value = "/delete")
    @RequiresAuthentication
    JsonResult deleteCat(@RequestBody ImiaoMao imiaoMao) {
        if (imiaoMao == null) {
            return JsonResult.errorMsg("删除失败");
        }

        return JsonResult.ok();
    }

    /**
     * TODO 删除多个图片记录
     * @param list
     * @return
     */
    @PostMapping(value = "/deleteList")
    @RequiresAuthentication
    JsonResult deleteCats(@RequestBody List<ImiaoMao> list) {
        if (list == null) {
            return JsonResult.errorMsg("删除失败");
        }

        return JsonResult.ok();
    }

    @PostMapping(value = "/update")
    @RequiresAuthentication
    int updateCatState(
            @RequestParam(defaultValue = "") String ids,
            @RequestParam(defaultValue = "0") int state) {
        return imiaoService.updateCatState(ids, state);
    }
}
