package com.formapp;

import java.util.HashMap;
import java.util.Map;

public class TableToClassMapping {

	private static Map<String, String> tableToClassMapping = new HashMap<>();

	public String getClass(String mysqlKey) {
		return tableToClassMapping.get(mysqlKey);
	}

	public void addToMysqlTable(String mysqlTable, String javaClass) {
		tableToClassMapping.put(mysqlTable, javaClass);
	}

}
