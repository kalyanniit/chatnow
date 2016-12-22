package com.chat.dao;

import java.util.List;

import com.chat.model.JobRegistration;
import com.chat.model.Jobs;

public interface JobsDao {
	
		 void addJob(Jobs job);
		   List<Jobs> viewJobs();
		   void deleteJob(int id);
		   void updateJob(Jobs job);
		   Jobs viewJob(int id);
		   void registerJob(JobRegistration jobRegistration);
		}

