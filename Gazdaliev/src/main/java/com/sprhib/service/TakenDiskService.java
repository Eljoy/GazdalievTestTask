package com.sprhib.service;

import com.sprhib.model.TakenDisk;

import java.util.List;

/**
 * Created by Home on 17.01.2015.
 */
public interface TakenDiskService {
    public void getOtherDisk(TakenDisk takenDisk);
    public void giveOtherDisk(int id);
    public List<TakenDisk> getTakenDisks();
    public TakenDisk getTakenDisk(int id);
    public void deleteTakenDisk(int id);
}
