package ru.bellintegrator.api.controller.catalogs;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.bellintegrator.api.service.CountryService;
import ru.bellintegrator.api.service.DocumentService;
import ru.bellintegrator.api.views.CountryView;
import ru.bellintegrator.api.views.DocumentView;

/**
 * контроллер сервлетов для списка стран и документов
 */
@Api("OrganizationController")
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class CatalogsController {

	private final CountryService countryService;
	private final DocumentService docService;

	/**
	 * внедрение зависимости сервисов необходимых для работы котроллера 
	 * обрабатывающего запросы к списку документов и стран
	 */
	@Autowired
	public CatalogsController(CountryService countryService, DocumentService docService) {
		this.countryService = countryService;
		this.docService = docService;
	}

	/**
	 * метод контроллера сервлетов ответственных за обратку маппинга списка стран
	 */
	@ApiOperation(value = "получить список всех стран", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value = "/countries")
	public List<CountryView> showCountryList() {
		List<CountryView> countries = countryService.getAllCountries();
		return countries;
	}

	/**
	 * метод контроллера сервлетов ответственных за обратку маппинга списка типов документов
	 */
	@ApiOperation(value = "получить список всех документов", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@GetMapping(value = "/docs")
	public List<DocumentView> showDocumentsList() {
		List<DocumentView> docs = docService.getAllDocumentTypes();
		return docs;
	}
}
