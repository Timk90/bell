package ru.bellintegrator.api.controller.organization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.bellintegrator.api.service.OrganizationService;
import ru.bellintegrator.api.views.OrganizationView;

//what is a static import? 
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Api("OrganizationController")
@RestController
@RequestMapping(value="api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
	
	private final OrganizationService organizationService;
	
	@Autowired
	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	
	@ApiOperation(value = "получить организацию по id", httpMethod="POST" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value="/{id}")
	public OrganizationView organizationByID(@PathVariable Long id) {
		return organizationService.getOrgById(id);
	}
	
	@ApiOperation(value = "получить организации по имени, инн", httpMethod="POST" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value="/list")
	public List<OrganizationView> organizationsByName(@RequestBody OrganizationView view) {
		 List<OrganizationView> views  = organizationService.listOrgByName(view);
		 System.out.println(views);
		 return views;
	}
	
	@ApiOperation(value = "получить организации по имени, инн", httpMethod="GET" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value="/list")
	public List<OrganizationView> allOrganizations() {
		 return organizationService.organizations();
	}
	
	@ApiOperation(value = "добавить новую организацию", httpMethod="POST" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value="/save")
	public void insertNewOrganization(@RequestBody OrganizationView view) {
		 System.out.println(view);
		 organizationService.insertOrganization(view);
	}
	
	@ApiOperation(value = "Изменить данные организации", httpMethod="POST" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value="/update")
	public void updateOrganization(@RequestBody OrganizationView view) {
		 System.out.println(view);
		 organizationService.updateOrganization(view);
	}
	
}
