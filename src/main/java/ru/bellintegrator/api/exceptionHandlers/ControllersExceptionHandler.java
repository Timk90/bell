package ru.bellintegrator.api.exceptionHandlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.bellintegrator.api.exceptions.NoSuchOfficeException;
import ru.bellintegrator.api.exceptions.UserDetailsInsertException;
import ru.bellintegrator.api.views.ErrorView;

@ControllerAdvice
public class ControllersExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(NoSuchOfficeException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleNoSuchOfficeException(NoSuchOfficeException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such office exists");
		//add logger	
		return error;
	}
	
	@ResponseBody
	@ExceptionHandler(UserDetailsInsertException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleNoUsernameOrPostionException(UserDetailsInsertException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect/adsent username or position");
		//add logger	
		return error;
	}
	
}
