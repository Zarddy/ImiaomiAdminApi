package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.ImiaoMao;
import cn.imiaomi.admin.api.service.impl.ImiaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cat")
public class CatController {

    @Autowired
    private ImiaoServiceImpl imiaoService;

    @PostMapping(value = "/list")
    List<ImiaoMao> listCats(
            @RequestParam(defaultValue = "0") int state,
            @RequestParam(defaultValue = "0") int page) {
        return imiaoService.listCatsByState(state, page);
    }

    @PostMapping(value = "/detail")
    ImiaoMao getDetail(@RequestParam(defaultValue = "") String id) {
        return imiaoService.getCatById(id);
    }

    @PostMapping(value = "/delete")
    int deleteCatByIds(@RequestParam(defaultValue = "") String ids) {
        return imiaoService.deleteCatByIds(ids);
    }

    @PostMapping(value = "/update")
    int updateCatState(
            @RequestParam(defaultValue = "") String ids,
            @RequestParam(defaultValue = "0") int state) {
        return imiaoService.updateCatState(ids, state);
    }
}
