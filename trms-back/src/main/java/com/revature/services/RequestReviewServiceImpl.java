package com.revature.services;

import java.util.Set;

import com.revature.beans.Comment;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.data.ReimbursementDAO;
import com.revature.data.postgres.ReimbursementPostgres;

public class RequestReviewServiceImpl implements RequestReviewService{
	private ReimbursementDAO reimbDao= new ReimbursementPostgres();
	@Override
	public Set<Reimbursement> getPendingReimbursements(Employee approver) {
	
		
		return (reimbDao.getByRequestor(approver));
	}
/**
 * Approving or rejecting requests requires us to create a Status object. 
 * so we can update the status within the reimbursement setstatus method.
 * */
	@Override
	public void approveRequest(Reimbursement request) {
		Status approvestat =request.getStatus();
		approvestat.setName("Approved");
		request.setStatus(approvestat);
		reimbDao.update(request);
	}

	@Override
	public void rejectRequest(Reimbursement request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectRequest(Reimbursement request, Comment comment) {
		// TODO Auto-generated method stub
		
	}

}
