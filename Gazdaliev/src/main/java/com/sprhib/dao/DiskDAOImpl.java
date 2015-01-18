package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Disk;

@Repository
public class DiskDAOImpl implements DiskDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addDisk(Disk disk) {
		getCurrentSession().save(disk);
	}

	public void updateDisk(Disk disk) {
		Disk diskToUpdate = getDisk(disk.getId());
		diskToUpdate.setName(disk.getName());
		diskToUpdate.setDescription(disk.getDescription());
		getCurrentSession().update(diskToUpdate);
	}

	public Disk getDisk(int id) {
		Disk disk = (Disk) getCurrentSession().get(Disk.class, id);
		return disk;
	}

	public void deleteDisk(int id) {
		Disk disk = getDisk(id);
		if (disk != null)
			getCurrentSession().delete(disk);
	}

	@SuppressWarnings("unchecked")
	public List<Disk> getDisks() {
		return getCurrentSession().createQuery("from Disk").list();
	}

}
