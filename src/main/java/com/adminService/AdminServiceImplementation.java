package com.adminService;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bindings.CaseWorkerData;
import com.bindings.PlansData;
import com.entity.CaseWorkerEntity;
import com.entity.PlansEntity;
import com.repo.CaseWorkerRepo;
import com.repo.PlansRepo;
import com.utility.EmailUtil;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private CaseWorkerRepo caseWorkerRepo;

	@Autowired
	private PlansRepo plansRepo;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Boolean addCaseWorkerData(CaseWorkerData caseWorkerData) {

		CaseWorkerEntity caseWorkerEntity = new CaseWorkerEntity();

		BeanUtils.copyProperties(caseWorkerData, caseWorkerEntity);
		caseWorkerEntity.setSsnNumber(caseWorkerData.getSsn());
		caseWorkerEntity.setAccountStatus("LOCKED");
		caseWorkerRepo.save(caseWorkerEntity);

		String to = caseWorkerData.getEmailId();
		String subject = "Unlock your account here";
		StringBuffer body = new StringBuffer("");
		body.append("Use below link to unlock your account");
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click here to unlock your Account</a>");

		Boolean sentEmail = emailUtil.sentEmail(body.toString(), to, subject);
		return sentEmail;

	}

	@Override
	public String unlockAccount(String emailId) {
		CaseWorkerEntity byEmail = caseWorkerRepo.findByEmailId(emailId);
		if (byEmail == null) {
			return "Check Your email Id";
		} else {
			byEmail.setAccountStatus("UNLOCKED");
			caseWorkerRepo.save(byEmail);
		}
		return "Your account is Unlocked";
	}

	@Override
	public List<CaseWorkerEntity> viewAllAccounts() {

		List<CaseWorkerEntity> caseWorkers = caseWorkerRepo.findAll();
		return caseWorkers;
	}

	@Override
	public String addPlns(PlansData plansData) {
		PlansEntity plansEntity = new PlansEntity();
		plansEntity.setPlanName(plansData.getPlanName());
		plansEntity.setActiveSW(plansData.getActiveSW());
		plansRepo.save(plansEntity);
		return "Plan added !";

	}
	@Override
	public List<PlansEntity> viewAllPlans() {
		
		List<PlansEntity> allplans = plansRepo.findAll();
		return allplans;
	}

}
