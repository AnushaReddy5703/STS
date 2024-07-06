package com.onlineDemo.eventService.OpenApi;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI defineOpenapi(){
		Server server=new Server();
		server.setUrl("http://localhost:8080");
		server.setDescription("demo");
		
		Contact contact=new Contact();
		contact.setName("Anusha");
		contact.setEmail("anusha@gmail.com");
		
		Info info=new Info()
				.title("Event management api")
				.version("1.0")
				.description("Expose endpoints to manage events")
				.contact(contact);
		return new OpenAPI().info(info).servers(List.of(server));
				
	}
	
	

}
	
