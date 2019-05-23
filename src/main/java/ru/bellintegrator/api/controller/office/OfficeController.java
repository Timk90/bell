package ru.bellintegrator.api.controller.office;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import ru.bellintegrator.api.service.OfficeService;
import ru.bellintegrator.api.views.OfficeView;
import ru.bellintegrator.api.views.OrganizationView;

@Api("OfficeController")
@RestController
@RequestMapping(value="api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
	
	private final OfficeService officeService;
	
	@Autowired
	public OfficeController(OfficeService officeService) {
		this.officeService = officeService;
	}

	@ApiOperation(value = "получить список офисов", httpMethod="GET" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value="/list")
	List<OfficeView> offices(){
		return officeService.offices();
	}
	
	@ApiOperation(value = "получить список офисов", httpMethod="POST" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value="/list")
	List<OfficeView> officesList(@RequestBody OfficeView view){
		return officeService.listOfficesByOrgId(view);
	}
	
	@ApiOperation(value = "получить офис по ID", httpMethod="GET" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value="/{id}")
	OfficeView getOffice(@PathVariable Long id){
		return officeService.getOfficeById(id);
	}
	
	@ApiOperation(value = "добавить новый офис по ID организации" , httpMethod="POST" )
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value="/save")
	void insertOffice(@RequestBody OfficeView office){
		officeService.insertOffice(office);
	}
	
}
