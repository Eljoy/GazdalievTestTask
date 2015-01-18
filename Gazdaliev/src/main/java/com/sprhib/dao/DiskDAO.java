package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Disk;

public interface DiskDAO {
	
	public void addDisk(Disk disk);
	public void updateDisk(Disk disk);
	public Disk getDisk(int id);
	public void deleteDisk(int id);
	public List<Disk> getDisks();

}
