package com.sprhib.dao;

import com.sprhib.model.TakenDisk;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TakenDiskDAOImpl implements TakenDiskDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void getOtherDisk(TakenDisk takenDisk) {
        getCurrentSession().save(takenDisk);
    }

    @Override
    public void giveOtherDisk(int id) {
        TakenDisk takenDisk = getTakenDisk(id);
        if(takenDisk != null)
            getCurrentSession().delete(takenDisk);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TakenDisk> getTakenDisks() {
        return getCurrentSession().createQuery("from TakenDisk").list();
    }

    @Override
    public TakenDisk getTakenDisk(int id) {
        return (TakenDisk)getCurrentSession().get(TakenDisk.class, id);
    }

    @Override
    public void deleteTakenDisk(int id) {
        TakenDisk takenDisk = getTakenDisk(id);
        if(takenDisk != null)
            getCurrentSession().delete(takenDisk);
    }
}
