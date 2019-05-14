package ru.bellintegrator.api.controller.user;

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
import ru.bellintegrator.api.model.User;
import ru.bellintegrator.api.service.UserService;
import ru.bellintegrator.api.views.UserView;

//what is a static import? 
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Api(value = "UserController")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Добавить нового сотрудника", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
	@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@PostMapping("/users")
	public void person(@RequestBody User user) {
		userService.insertUser(user);
	}

	@ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
	@GetMapping("/list")
	public List<UserView> persons() {
		List<UserView> users = userService.users();
		//List<UserView> userViews = mapAllUsers(users);
		for (UserView uv : users) {
			System.out.println(uv.toString());
		}
		return users;
	}

	@ApiOperation(value = "Получить конкретного человека", httpMethod = "GET")
	@GetMapping("/{id}")
	public UserView person(@PathVariable Long id) {
		UserView user = userService.getUserById(id);
		System.out.println(user.toString());
		return user;
	}

}
