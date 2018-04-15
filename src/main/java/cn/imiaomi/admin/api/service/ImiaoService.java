package cn.imiaomi.admin.api.service;

import cn.imiaomi.admin.api.pojo.ImiaoMao;

import java.util.List;

public interface ImiaoService {

    List<ImiaoMao> listCatsByState(int state, int page);

    ImiaoMao getCatById(String id);

    int deleteCatByIds(String ids);

    int updateCatState(String ids, int state);
}
