package com.revature.app;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.revature.controllers.RequestsController;


public class TRMSApp {
	
	public static void main(String[] args) {
		ObjectMapper mapper = JsonMapper.builder()
			    .findAndAddModules()
			    .build();
		Javalin app = Javalin.create().start();
		
		app.routes(() -> {
			path("/requests", () -> {
				post(RequestsController::submitReimbursementRequest);
				path("/requestor/{id}", () -> {
					get(RequestsController::getRequestsByRequestor);
				});
			});
		});
	}

}
