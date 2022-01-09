package com.revature.controllers;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.beans.Status;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.RequestReviewService;
import com.revature.services.RequestReviewServiceImpl;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class RequestsController {
	private static EmployeeService empServ = new EmployeeServiceImpl();
	private static RequestReviewService rrServ = new RequestReviewServiceImpl();
	
	//private static Logger log = LogManager.getLogger(RequestsController.class);
	
	/**
	 * Retrieves the submitted reimbursement request from the
	 * HTTP request body and sends it to be inserted in the database.
	 * <p>
	 * If the insertion is not successful, sends an HTTP response
	 * with a status code of 400 (Bad Request) and a message stating
	 * that something went wrong.
	 * <p>
	 * If the insertion is successful, sends an HTTP response with
	 * a status code of 201 (Created) and the submitted request with
	 * its newly generated ID.
	 * <p>
	 * This method should be handling a POST request.
	 * 
	 * @param ctx Javalin's Context object representing the HTTP request and response
	 */
	public static void submitReimbursementRequest(Context ctx) {
		//log.info("User is submitting reimbursement");
		//System.out.println(ctx);
		Reimbursement request = ctx.bodyAsClass(Reimbursement.class);
		try {
		if(request.getRequestor().getEmpId()==0) {
			ctx.status(400);
			ctx.result("No such employee exists");
		}
		else
			
		{
		int reqId = empServ.submitReimbursementRequest(request);
		
		if (reqId != 0) {
			ctx.status(HttpCode.CREATED);
			request.setReqId(reqId);
			ctx.json(request);
		} else {
			ctx.status(400);
			ctx.result("Something went wrong with your submission. Please try again.");
		}
		}
		}
		catch (Exception e) {
			ctx.status(400);
			ctx.result("Requestor ID must be an integer. Please try again.");
		}
	}
	
	/**
	 * Sends an HTTP response containing the reimbursement requests
	 * associated with a particular employee who submitted them based
	 * on that employee's ID (which is sent as a path variable).
	 * <p>
	 * If the ID is of the correct format and the employee exists in
	 * the database, the requests are returned with a status code of 200.
	 * <p>
	 * If the ID is of the correct format but the employee does not
	 * exist, a response is sent with a status code of 404 (Not Found)
	 * and a message stating that the user does not exist.
	 * <p>
	 * If the ID is <strong>not</strong> of the correct format, a
	 * response is sent with a status code of 400 (Bad Request) and
	 * a message stating that the ID must be an integer.
	 * 
	 * @param ctx Javalin's Context object representing the HTTP request and response
	 */
	public static void getRequestsByRequestor(Context ctx) {
		
		String requestorIdStr = ctx.pathParam("id");
		//log.info("User is requesting all reimbursements");
		//System.out.println("lookup");
		try {
			int requestorId = Integer.valueOf(requestorIdStr);
			Employee requestor = empServ.getEmployeeById(requestorId);
			
			if (requestor != null) {
				ctx.json(empServ.getReimbursementRequests(requestor));
			} else {
				ctx.status(404);
				ctx.result("The user you specified does not exist.");
			}
		} catch (NumberFormatException e) {
			ctx.status(400);
			ctx.result("Requestor ID must be an integer. Please try again.");
		}
	}
	
	/**
	 * Gets employee object from database for use in front end.
	 * 
	 * 
	 * 
	 *
	 *
	 */
	
	
	public static void getEmployeeById(Context ctx) {
		String requestorIdStr = ctx.pathParam("id");
		try {
			int empid = Integer.valueOf(requestorIdStr);
			Employee emp = empServ.getEmployeeById(empid);;
			if(emp!=null) {
				ctx.json(empServ.getEmployeeById(empid));
			}
			else {
			ctx.status(404);
			ctx.result("The user you specified does not exist.");
			}
			
		}
		catch  (NumberFormatException e) {
			ctx.status(400);
			ctx.result("Requestor ID must be an integer. Please try again.");
		}
		
		
		
	}
	
	/**
	 * sends pending requests by employee
	 * 
	 * 
	 * 
	 * 
	 * */
	
public static void getPendingRequestsByRequestor(Context ctx) {
		
		String requestorIdStr = ctx.pathParam("id");

		try {
			int requestorId = Integer.valueOf(requestorIdStr);
			Employee requestor = empServ.getEmployeeById(requestorId);
			
			if (requestor != null) {
				ctx.json(rrServ.getPendingReimbursements(requestor));
			} else {
				ctx.status(404);
				ctx.result("There are no pending requests");
			}
		} catch (NumberFormatException e) {
			ctx.status(400);
			ctx.result("Requestor ID must be an integer. Please try again.");
		}
	}

/**
 * Approves request by changing its status
 * Front end handles user that is approving it
 * */
public static void approve(Context ctx) {

	String requestorIdStr = ctx.pathParam("id");
	Status stat = ctx.bodyAsClass(Status.class);
	
	try {
		int requestorId = Integer.valueOf(requestorIdStr);
		Reimbursement request =rrServ.getById(requestorId);
		request.setStatus(stat);
		rrServ.approveRequest(request);
		ctx.status(202);
		ctx.json(request);
	} catch (NumberFormatException e) {
		ctx.status(406);
		ctx.result("Invalid request. Please try again.");
	}
}
public static void deny(Context ctx) {

	String requestorIdStr = ctx.pathParam("id");
	Status stat = ctx.bodyAsClass(Status.class);
	try {
		int requestorId = Integer.valueOf(requestorIdStr);
		Reimbursement request =rrServ.getById(requestorId);
		System.out.println(requestorId);
		request.setStatus(stat);
		rrServ.rejectRequest(request);
		ctx.status(202);
		ctx.json(request);
	} catch (NumberFormatException e) {
		ctx.status(406);
		ctx.result("Invalid request. Please try again.");
	}
}

}
