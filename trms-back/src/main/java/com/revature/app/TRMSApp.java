package com.revature.app;

import io.javalin.Javalin;
import io.javalin.plugin.json.JsonMapper;

import static io.javalin.apibuilder.ApiBuilder.*;

import java.io.IOException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.controllers.RequestsController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TRMSApp {

	public static void main(String[] args) {
	//	Javalin app = Javalin.create().start();
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.jsonMapper(new JacksonMapper());
		}).start();
		
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



class JacksonMapper implements JsonMapper {
    ObjectMapper om = new ObjectMapper();

    {
        om.findAndRegisterModules();
    }

    @Override
    public String toJsonString(Object obj) {
        try {
            return om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public <T> T fromJsonString(String json, Class<T> targetClass) {
        try {
            return om.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
}