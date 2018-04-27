package cn.imiaomi.admin.api.service;

import cn.imiaomi.admin.api.pojo.ImiaoMao;
import com.github.pagehelper.Page;

import java.util.List;

public interface ImiaoService {

    Page<ImiaoMao> listCatsByState(int state, int page, int pageSize);

    ImiaoMao getCatById(String id);

    int deleteCatByIds(String ids);

    int updateCatState(String ids, int state);
}
