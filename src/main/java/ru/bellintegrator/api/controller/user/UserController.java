package ru.bellintegrator.api.controller.user;

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
import ru.bellintegrator.api.service.UserService;
import ru.bellintegrator.api.views.SuccessView;
import ru.bellintegrator.api.views.UserView;

/**
 * контроллер сервлетов ответственный за работу с запросами к таблице сотрудника
 */
@Api(value = "UserController")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

	private final UserService userService;

	/**
	 * внедрение зависимости на интерфейс сервиса сотрудника через конструктор
	 */
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * обработка http запроса на добавление нового сотрудника по заданному фильтру
	 * 
	 * @param officeId        (обязательный)
	 * 
	 * @param firstName       (обязательный)
	 * 
	 * @param secondName
	 * 
	 * @param middleName
	 * 
	 * @param position        (обязательный)
	 * 
	 * @param docCode
	 * 
	 * @param docName
	 * 
	 * @param docDate
	 * 
	 * @param citizenshipCode
	 * 
	 * @param isIdentified
	 */
	@ApiOperation(value = "Добавить нового сотрудника", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping("/save")
	public SuccessView insertPerson(@RequestBody UserView user) {
		return userService.insertUser(user);
	}

	/**
	 * обработка http запроса на изменение данных сотрудника по заданному фильтру
	 * 
	 * @param id              (обязатаельный)
	 * 
	 * @param officeId
	 * 
	 * @param firstName       (обязательный)
	 * 
	 * @param secondName
	 * 
	 * @param middleName
	 * 
	 * @param position        (обязательный)
	 * 
	 * @param docCode
	 * 
	 * @param docName
	 * 
	 * @param docDate
	 * 
	 * @param citizenshipCode
	 * 
	 * @param isIdentified
	 */
	@ApiOperation(value = "Изменить запись сотрудника", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping("/update")
	public SuccessView updatePerson(@RequestBody UserView user) {
		return userService.updateUser(user);
	}

	/**
	 * обработка http запроса на получение списка всех сотрудников
	 */
	@ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
	@GetMapping("/list")
	public List<UserView> persons() {
		List<UserView> users = userService.users();
		return users;
	}

	/**
	 * обработка http запроса на поиск сотрудника по заданному id в URL запроса
	 * 
	 * @pathVariable id (обязательный)
	 */
	@ApiOperation(value = "Получить конкретного сотрудника", httpMethod = "GET")
	@GetMapping("/{id}")
	public UserView person(@PathVariable Long id) {
		UserView user = userService.getUserById(id);
		return user;
	}

}
