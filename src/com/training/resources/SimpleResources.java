package com.training.resources;

import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.owlike.genson.Genson;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

@Path("/simple")
public class SimpleResources {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {

		return "configured rest successfully";
	}

	@GET
	@Path("/name")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployee() {

		String empRep = null;
		Employee emp = new Employee("101", "Ramesh");

		Genson serializer = new Genson();

		empRep = serializer.serialize(emp);

		return empRep;
	}

	@POST
	@Path("/add")
	public String addEmployee(@FormParam("id") String empId, @FormParam("name") String empName) {
		String message = null;
		Employee emp = new Employee(empId, empName);
		message = emp.toString();
		return "one employee with " + message + "Added";

	}

	@DELETE
	@Path("/delete/{empId}")
	public String deleteEmployee(@PathParam("empId") String empId) {

		return "one employee deleted with " + empId + " deleted";
	}

	@Path("/findAll")

	@GET
	public Response findAllEmployees(@QueryParam("dept") String department)
	{
		HashMap<String, Employee> list=new HashMap<String,Employee>();
		list.put("HR", new Employee("101","Ramesh"));
		list.put("IT", new Employee("102","Rajesh"));
		list.put("AD", new Employee("103","Rakesh"));
		Employee found=list.get(department);
		return Response.status(200).entity(found).build();
	
	}
	
}