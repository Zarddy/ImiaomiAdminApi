package cn.imiaomi.admin.api.service.impl;

import cn.imiaomi.admin.api.mapper.ImiaoMaoMapper;
import cn.imiaomi.admin.api.pojo.ImiaoMao;
import cn.imiaomi.admin.api.pojo.ImiaoResource;
import cn.imiaomi.admin.api.service.ImiaoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImiaoServiceImpl implements ImiaoService {

    @Autowired
    ImiaoResource imiaoResource;
    @Autowired
    ImiaoMaoMapper imiaoMaoMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ImiaoMao> listCatsByState(int state, int page) {
        PageHelper.startPage(page, imiaoResource.getPageSize()); // 分页
        return imiaoMaoMapper.listCatsByState(state);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ImiaoMao getCatById(String id) {
        return imiaoMaoMapper.getCatById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteCatByIds(String ids) {
        return updateCatState("(" + ids + ")", 0);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateCatState(String ids, int state) {
        return imiaoMaoMapper.updateStateByIds("(" + ids + ")", state);
    }
}
