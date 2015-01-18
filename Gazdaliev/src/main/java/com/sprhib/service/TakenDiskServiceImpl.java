package com.sprhib.service;

import com.sprhib.dao.TakenDiskDAO;
import com.sprhib.model.TakenDisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Home on 17.01.2015.
 */
@Service
@Transactional
public class TakenDiskServiceImpl implements TakenDiskService {
    @Autowired
    TakenDiskDAO takenDiskDAO;

    @Override
    public void getOtherDisk(TakenDisk takenDisk) {
        takenDiskDAO.getOtherDisk(takenDisk);
    }

    @Override
    public void giveOtherDisk(int id) {
        takenDiskDAO.giveOtherDisk(id);
    }

    @Override
    public List<TakenDisk> getTakenDisks() {
        return takenDiskDAO.getTakenDisks();
    }

    @Override
    public TakenDisk getTakenDisk(int id) {
        return takenDiskDAO.getTakenDisk(id);
    }

    @Override
    public void deleteTakenDisk(int id) {
        takenDiskDAO.deleteTakenDisk(id);
    }
}
