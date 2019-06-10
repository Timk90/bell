package ru.bellintegrator.api.exceptionHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

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
import ru.bellintegrator.api.exceptions.NoSuchUserException;
import ru.bellintegrator.api.views.DataView;
import ru.bellintegrator.api.views.ErrorView;
import ru.bellintegrator.api.views.SuccessView;

/**
 * класс обработки exceptions и оборачивания полученных данных из views в json
 * объект {"data":"{...}"}
 */
@ControllerAdvice
public class ControllersExceptionHandler implements ResponseBodyAdvice<Object> {

	/**
	 * добавление логирования
	 */
	Logger logger = LoggerFactory.getLogger(ControllersExceptionHandler.class);

	/**
	 * включена поддержка всех запросов методом beforeBodyWrite без исключений и
	 * ограничений
	 */
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	/**
	 * при успешном запросе метод оборачивает views в json data.
	 */
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (!body.getClass().equals(SuccessView.class) && !body.getClass().equals(ErrorView.class)) {
			DataView data = new DataView();
			data.setData(body);
			return data;
		}
		return body;
	}

	/**
	 * обработка исключения при указании данных несуществующего пользователя
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(NoSuchUserException.class)
	public ErrorView handleNoSuchUserException(NoSuchUserException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such user exists in DB");
		logger.warn("No such user exists in DB");
		return error;
	}

	/**
	 * обработка исключения при указании данных несуществующего офиса
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(NoSuchOfficeException.class)
	public ErrorView handleNoSuchOfficeException(NoSuchOfficeException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such office exists");
		logger.warn("No such office exists");
		return error;
	}

	/**
	 * обработка исключения при неправильном указании данных существующего
	 * пользователя
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectUserDetailsException.class)
	public ErrorView handleNoUsernameOrPostionException(IncorrectUserDetailsException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect/adsent username or position");
		logger.warn("Incorrect/adsent username or position");
		return error;
	}

	/**
	 * обработка исключения при неправильном указании данных существующего
	 * пользователя при попытке их изменения
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorretUserUpdateDataException.class)
	public ErrorView handleNoUsernameOrPostionException(IncorretUserUpdateDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect/adsent id, username or position");
		logger.warn("Incorrect/adsent  id, username or position");
		return error;
	}

	/**
	 * обработка исключения при неправильном указании данных для вставки нового
	 * пользователя
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(InsertUserException.class)
	public ErrorView handleInsertUserException(InsertUserException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect data for insert");
		logger.error("Incorrect data for insert");
		return error;
	}

	/**
	 * обработка исключения при неправильном указании формата даты
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectDateFormatException.class)
	public ErrorView handleIncorrectDataFormatException(IncorrectDateFormatException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect date format. Data should has fallowing format: dd-MM-yyyy; Example: 31-02-2012");
		logger.error("Incorrect data for insert");
		return error;
	}

	/**
	 * обработка исключения при указании данных несуществующей страны
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(NoSuchCountryException.class)
	public ErrorView handleNoSuchCountryException(NoSuchCountryException ex) {
		ErrorView error = new ErrorView();
		error.setError("There is no country found with this country code");
		logger.warn("There is no country found with this country code");
		return error;
	}

	/**
	 * обработка исключения при указании данных несуществующего документа
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(NoSuchDocumentException.class)
	public ErrorView handleNoSuchDocumentException(NoSuchDocumentException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such document exists");
		logger.warn("No such document exists");
		return error;
	}

	/**
	 * обработка исключения при указании неправильного id (не целое число типа Long)
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectIdFormatException.class)
	public ErrorView handleIncorrectIdFormatException(IncorrectIdFormatException ex) {
		ErrorView error = new ErrorView();
		error.setError("Incorrect Id value. Only numerical natural values are excpected.");
		logger.warn("Incorrect Id value. Only numerical natural values are excpected");
		return error;
	}

	/**
	 * обработка исключения при указании некорректных данных для изменения офиса
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectOfficeUpdateDataException.class)
	public ErrorView handleIncorrectOfficeUpdateDataException(IncorrectOfficeUpdateDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To update office the next fields are required: id, name, address.");
		logger.warn("To update office the next fields are required: id, name, address.");
		return error;
	}

	/**
	 * обработка исключения при указании некорректных данных для в вставки нового
	 * офиса
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectOfficeInsertDataException.class)
	public ErrorView handleIncorrectOfficeUpdateDataException(IncorrectOfficeInsertDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To insert a new office ID field is required.");
		logger.warn("To insert a new office ID field is required.");
		return error;
	}

	/**
	 * обработка исключения при указании некорректных данных для вставки новой
	 * организации
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectInsertOrganizationDataException.class)
	public ErrorView handleIncorrectInsertOrganizationDataException(IncorrectInsertOrganizationDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To add a new organizations: fullName, inn, kpp, address are required.");
		logger.warn("To add a new organizations: fullName, inn, kpp, address are required.");
		return error;
	}

	/**
	 * обработка исключения при неправильном указании данных для изменения
	 * организации
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IncorrectUpdateOrganizationDataException.class)
	public ErrorView handleIncorrectUpdateOrganizationDataException(IncorrectUpdateOrganizationDataException ex) {
		ErrorView error = new ErrorView();
		error.setError("To update an organization: id, fullName, inn, kpp, address are required.");
		logger.warn("To update an organization: id, fullName, inn, kpp, address are required.");
		return error;
	}

	/**
	 * обработка исключения при указании данных несуществующей организации
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(NoSuchOrganizationException.class)
	public ErrorView handleNoSuchOrganizationException(NoSuchOrganizationException ex) {
		ErrorView error = new ErrorView();
		error.setError("No such organization exists");
		logger.warn("No such organization exists");
		return error;
	}

	/**
	 * обработка остальных типов неучтенных исключений
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ErrorView handleException(Exception ex) {
		ErrorView error = new ErrorView();
		error.setError("Unexpected Error has occured");
		logger.error("Unknown Error has occured");
		return error;
	}

}
