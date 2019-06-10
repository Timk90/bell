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
import ru.bellintegrator.api.views.SuccessView;

/**
 * контроллер сервлетов ответственный за работу с запросами к таблице офисов 
 */
@Api("OfficeController")
@RestController
@RequestMapping(value = "api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

	private final OfficeService officeService;

	/**
	 * внедрение зависимости на интерфейс сервиса офисов через конструктор
	 */
	@Autowired
	public OfficeController(OfficeService officeService) {
		this.officeService = officeService;
	}

	/**
	 * обработка http запроса на получение списка всех офисов
	 */
	@ApiOperation(value = "получить список офисов", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value = "/list")
	List<OfficeView> offices() {
		return officeService.offices();
	}

	/**
	 * обработка http запроса на получение списка офисов по заданному фильтру
	 * 
	 * @param id (обязательный), name, phone, isActive
	 */
	@ApiOperation(value = "получить список офисов", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value = "/list")
	List<OfficeView> officesList(@RequestBody OfficeView view) {
		return officeService.listOfficesByOrgId(view);
	}

	/**
	 * обработка http запроса на поиск офиса по заданному id в URL
	 * 
	 * @pathVariable id (обязательный)
	 */
	@ApiOperation(value = "получить офис по ID", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value = "/{id}")
	OfficeView getOffice(@PathVariable Long id) {
		return officeService.getOfficeById(id);
	}

	/**
	 * обработка http запроса на добавление нового офиса
	 * 
	 * @params idOrg (обязательный), name, address, phone, isActive
	 */
	@ApiOperation(value = "добавить новый офис по ID организации", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value = "/save")
	SuccessView insertOffice(@RequestBody OfficeView office) {
		return officeService.insertOffice(office);
	}

	/**
	 * обработка http запроса на изменение данных одного офиса
	 * 
	 * @params id (обязательный), name (обязательный), address (обязательный),
	 * phone, isActive
	 */
	@ApiOperation(value = "изменить данные офиса по ID организации", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping(value = "/update")
	SuccessView updateOffice(@RequestBody OfficeView office) {
		return officeService.updateOffice(office);
	}

}
