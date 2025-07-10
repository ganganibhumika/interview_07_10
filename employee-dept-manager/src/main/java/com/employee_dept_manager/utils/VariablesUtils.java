package com.employee_dept_manager.utils;

import java.text.SimpleDateFormat;

public class VariablesUtils {
	/**
	 * date format declaration
	 */

	public static final SimpleDateFormat SIMPLE_DATE_FORMAT_FOR_SEND_APP = new SimpleDateFormat("dd/MM/yyyy");

	public static final String DATE_FORMAT_FOR_DISPLAY = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	/**
	 * error message declaration
	 */
	public static final String ERROR = "error";
	public static final String INCOMPLETE_DATA = "Incomplete Data.";

	/**
	 * other's
	 */

	public static final String AES_KEY = "mvLBiZsiTbGwrf@!";
	public static final String ALREADYEXIST = "already exist.";
	public static final String SUCCESS = "Success";
	public static final String FAIL = "Fail";

	public static final String USER_NOT_FOUND = "User not Found.";

	/*
	 * Message for database operation  -- will latter add in assets/i18  or messages files
	 * */
	public static final String INCOMPLETE_REQUEST_DATA="Incomplete request data.";
	public static final String SAVE_DATA_SUCCESSFULLY="data save successfully.";
	public static final String DATA_ALREADY_EXIST="already exist.";
	public static final String RECORD_NOT_FOUND_IN_DB="Record not found in database.";
	public static final String UPDATE_DATA_SUCCESSFULLY="data update successfully.";
	public static final String DELETE_DATA_SUCCESSFULLY="data delete successfully.";
	public static final String GET_DATA_SUCCESSFULLY="Get data successfully.";
	
}
