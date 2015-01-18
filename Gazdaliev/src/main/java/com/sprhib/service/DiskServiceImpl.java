package com.sprhib.service;

import java.util.List;

import com.sprhib.dao.DiskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Disk;

@Service
@Transactional
public class DiskServiceImpl implements DiskService {
	
	@Autowired
	private DiskDAO diskDAO;

	public void addDisk(Disk disk) {
		diskDAO.addDisk(disk);
	}

	public void updateDisk(Disk disk) {
		diskDAO.updateDisk(disk);
	}

	public Disk getDisk(int id) {
		return diskDAO.getDisk(id);
	}

	public void deleteDisk(int id) {
		diskDAO.deleteDisk(id);
	}

	public List<Disk> getDisks() {
		return diskDAO.getDisks();
	}

}
