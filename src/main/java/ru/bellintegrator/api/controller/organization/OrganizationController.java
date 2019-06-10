package ru.bellintegrator.api.controller.organization;

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
import ru.bellintegrator.api.service.OrganizationService;
import ru.bellintegrator.api.views.OrganizationView;
import ru.bellintegrator.api.views.SuccessView;

/**
 * контроллер сервлетов ответственный за работу с запросами к таблице организаций 
 */
@Api("OrganizationController")
@RestController
@RequestMapping(value = "api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

	private final OrganizationService organizationService;

	/**
	 * внедрение зависимости на интерфейс сервиса организаций через конструктор
	 */
	@Autowired
	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	/**
	 * обработка http запроса на поиск организации по заданному id в URL запроса
	 * 
	 * @pathVariable id (обязательный)
	 */
	@ApiOperation(value = "получить организацию по id", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value = "/{id}")
	public OrganizationView organizationByID(@PathVariable Long id) {
		return organizationService.getOrgById(id);
	}

	/**
	 * обработка http запроса на поиск организации по заданному фильтру в URL
	 * запроса
	 * 
	 * @params name(обязательный), inn, isActive
	 */
	@ApiOperation(value = "получить организации по имени, инн", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value = "/list")
	public List<OrganizationView> organizationsByName(@RequestBody OrganizationView view) {
		List<OrganizationView> views = organizationService.listOrgByName(view);
		return views;
	}

	/**
	 * обработка http запроса на получение списка всех организации
	 */
	@ApiOperation(value = "получить список всех организаций", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value = "/list")
	public List<OrganizationView> allOrganizations() {
		return organizationService.organizations();
	}

	/**
	 * обработка http запроса на добавление новой организации
	 * 
	 * @params name(обязательный), fullName(обязательный), inn(обязательный),
	 * kpp(обязательный), address(обязательный), phone, isActive
	 */
	@ApiOperation(value = "добавить новую организацию", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value = "/save")
	public SuccessView insertNewOrganization(@RequestBody OrganizationView view) {
		return organizationService.insertOrganization(view);
	}

	/**
	 * обработка http запроса на изменение данных организации
	 * 
	 * @params id(обязательный), name(обязательный), fullName(обязательный),
	 * inn(обязательный), kpp(обязательный), address(обязательный), phone, isActive
	 */
	@ApiOperation(value = "Изменить данные организации", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value = "/update")
	public SuccessView updateOrganization(@RequestBody OrganizationView view) {
		return organizationService.updateOrganization(view);
	}

}
