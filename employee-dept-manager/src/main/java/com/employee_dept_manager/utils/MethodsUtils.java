package com.employee_dept_manager.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MethodsUtils {

	/**
	 * check given object is null or empty
	 * 
	 * @author bhumika
	 * @param t
	 * @return true if object is null or empty
	 */
	@SafeVarargs
	public static <T> boolean isObjectNullOrEmpty(T... t) {
		for (T obj : t) {

			if (obj == null || obj.toString().trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check map is null or empty
	 * 
	 * @author bhumika
	 * @param mapT
	 * @return true is map is null or empty
	 */

	public static <T> boolean isMapIsNullOrEmpty(Map<T, T> mapT) {
		if (mapT == null || mapT.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * check set is null or empty
	 * 
	 * @author bhumika
	 * @param setT
	 * @return true if set is null or empty
	 */

	public static <T> boolean isSetNullOrEmpty(Set<T> setT) {
		if (setT == null || setT.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * check list is null or empty
	 * 
	 * @param <T>
	 * @param list
	 * @return true if list is null or empty
	 */

	public static <T> boolean isListNullOrEmpty(List<T> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}
}
