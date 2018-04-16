package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.ImiaoMao;
import cn.imiaomi.admin.api.pojo.ImiaoResource;
import cn.imiaomi.admin.api.service.impl.ImiaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cat")
public class CatController {

    @Autowired
    private ImiaoResource imiaoResource;
    @Autowired
    private ImiaoServiceImpl imiaoService;

    @RequestMapping(value = "/list")
    List<ImiaoMao> listCats(
            @RequestParam(defaultValue = "0") int state,
            @RequestParam(defaultValue = "0") int page) {
        return imiaoService.listCatsByState(state, page);
    }

    @RequestMapping(value = "/detail")
    ImiaoMao getDetail(@RequestParam(defaultValue = "") String id) {
        return imiaoService.getCatById(id);
    }

    @RequestMapping(value = "/delete")
    int deleteCatByIds(@RequestParam(defaultValue = "") String ids) {
        return imiaoService.deleteCatByIds(ids);
    }

    @RequestMapping(value = "/update")
    int updateCatState(
            @RequestParam(defaultValue = "") String ids,
            @RequestParam(defaultValue = "0") int state) {
        return imiaoService.updateCatState(ids, state);
    }
}
