package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.JobDAO;
import com.niit.model.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO 
{
	
	@Autowired
    private SessionFactory sf;

	public void addJob(Job job)
	{
	Session s =sf.getCurrentSession();
	s.save(job);
	}
	public List<Job> getAllJobs()
	{
		Session s =sf.getCurrentSession();
		Query q=s.createQuery("from Job");
		List<Job> jobs=q.list();
		return jobs;
	}
	public void deleteJob(int id) 
	{
		Session s =sf.getCurrentSession();
		Job job=(Job)s.get(Job.class, id);
		s.delete(job);
		
	}
	public Job getJob(int id)
	{
		Session s =sf.getCurrentSession();
		Job job=(Job)s.get(Job.class, id);
		return job;
	}

	public void updateJob(Job job) 
	{
		Session session=sf.getCurrentSession();
		session.update(job);
		
	}

}
