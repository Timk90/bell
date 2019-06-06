package ru.bellintegrator.api.exceptionHandlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.bellintegrator.api.exceptions.IncorrectDateFormatException;
import ru.bellintegrator.api.exceptions.IncorrectIdFormatException;
import ru.bellintegrator.api.exceptions.IncorrectInsertOrganizationDataException;
import ru.bellintegrator.api.exceptions.IncorrectOfficeInsertDataException;
import ru.bellintegrator.api.exceptions.IncorrectOfficeUpdateDataException;
import ru.bellintegrator.api.exceptions.IncorrectUpdateOrganizationDataException;
import ru.bellintegrator.api.exceptions.IncorrectUserDetailsException;
import ru.bellintegrator.api.exceptions.IncorretUserUpdateDataException;
import ru.bellintegrator.api.exceptions.InsertUserException;
import ru.bellintegrator.api.exceptions.NoSuchCountryException;
import ru.bellintegrator.api.exceptions.NoSuchDocumentException;
import ru.bellintegrator.api.exceptions.NoSuchOfficeException;
import ru.bellintegrator.api.exceptions.NoSuchOrganizationException;
import ru.bellintegrator.api.views.ErrorView;

@ControllerAdvice
public class ControllersExceptionHandler {

	@ResponseBody
	@ExceptionHandler(NoSuchOfficeException.class)
	// @RequestMapping(value="/api/user/error+json")
	public ErrorView handleNoSuchOfficeException(NoSuchOfficeException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such office exists");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectUserDetailsException.class)
	public ErrorView handleNoUsernameOrPostionException(IncorrectUserDetailsException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect/adsent username or position");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorretUserUpdateDataException.class)
	public ErrorView handleNoUsernameOrPostionException(IncorretUserUpdateDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect/adsent id, username or position");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(InsertUserException.class)
	public ErrorView handleInsertUserException(InsertUserException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect data for insert");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectDateFormatException.class)
	public ErrorView handleIncorrectDataFormatException(IncorrectDateFormatException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect date format. Data should has fallowing format: dd-MM-yyyy; Example: 31-02-2012");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(NoSuchCountryException.class)
	public ErrorView handleNoSuchCountryException(NoSuchCountryException ex) {
		ErrorView error = new ErrorView();
		error.setError("There is no country found with this country code");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(NoSuchDocumentException.class)
	public ErrorView handleNoSuchDocumentException(NoSuchDocumentException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such document exists");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectIdFormatException.class)
	public ErrorView handleIncorrectIdFormatException(IncorrectIdFormatException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect Id value. Only numerical natural values are excpected.");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectOfficeUpdateDataException.class)
	public ErrorView handleIncorrectOfficeUpdateDataException(IncorrectOfficeUpdateDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To update office the next fields are required: id, name, address.");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectOfficeInsertDataException.class)
	public ErrorView handleIncorrectOfficeUpdateDataException(IncorrectOfficeInsertDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To insert a new office id is required.");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectInsertOrganizationDataException.class)
	public ErrorView handleIncorrectInsertOrganizationDataException(IncorrectInsertOrganizationDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To add a new organizations: fullName, inn, kpp, address are required.");
		// add logger
		return error;
	}

	@ResponseBody
	@ExceptionHandler(IncorrectUpdateOrganizationDataException.class)
	public ErrorView handleIncorrectUpdateOrganizationDataException(IncorrectUpdateOrganizationDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To update an organization: id, fullName, inn, kpp, address are required.");
		// add logger
		return error;
	}
	
	@ResponseBody
	@ExceptionHandler(NoSuchOrganizationException.class)
	public ErrorView handleNoSuchOrganizationException(NoSuchOrganizationException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such organization exists");
		// add logger
		return error;
	}
}
