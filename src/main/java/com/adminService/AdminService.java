package com.adminService;

import java.util.List;

import com.bindings.CaseWorkerData;
import com.bindings.PlansData;
import com.entity.CaseWorkerEntity;
import com.entity.PlansEntity;

public interface AdminService 
{
	public Boolean addCaseWorkerData(CaseWorkerData caseWorkerData);
	
	public String unlockAccount(String emailId);
	
	public List<CaseWorkerEntity> viewAllAccounts();
	
	public String addPlns(PlansData plansData);
	
	public List<PlansEntity> viewAllPlans();

}
