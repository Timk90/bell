package ru.bellintegrator.api.exceptionHandlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.bellintegrator.api.exceptions.IncorrectDateFormatException;
import ru.bellintegrator.api.exceptions.IncorretUserUpdateDataException;
import ru.bellintegrator.api.exceptions.InsertUserException;
import ru.bellintegrator.api.exceptions.NoSuchCountryException;
import ru.bellintegrator.api.exceptions.NoSuchDocumentException;
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
	
	@ResponseBody
	@ExceptionHandler(IncorretUserUpdateDataException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleNoUsernameOrPostionException(IncorretUserUpdateDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect/adsent id, username or position");
		//add logger	
		return error;
	}
	
	@ResponseBody
	@ExceptionHandler(InsertUserException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleInsertUserException(InsertUserException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect data for insert");
		//add logger	
		return error;
	}
	
	@ResponseBody
	@ExceptionHandler(IncorrectDateFormatException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleIncorrectDataFormatException(IncorrectDateFormatException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect date format. Data should has fallowing format: dd-MM-yyyy; Example: 31-02-2012");
		//add logger
		return error;
	}
	
	@ResponseBody
	@ExceptionHandler(NoSuchCountryException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleNoSuchCountryException(NoSuchCountryException ex) {
		ErrorView error = new ErrorView();
		error.setError("There is no country found with this country code");
		//add logger
		return error;
	}
	
	@ResponseBody
	@ExceptionHandler(NoSuchDocumentException.class)
	//@RequestMapping(value="/api/user/error+json")
	public ErrorView handleNoSuchDocumentException(NoSuchDocumentException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such document exists");
		//add logger	
		return error;
	}
	
}
