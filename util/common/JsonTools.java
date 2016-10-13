package com.yabushan.test.util.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}

	public static String toJsonString(Object object) {
		return JSON.toJSONString(object);
	}

	public static <T> T getFastJsonObject(String jsonString, Class<T> cls) {
		T t = null;
		t = JSON.parseObject(jsonString, cls);
		return t;
	}

	public static Map<String, Object> getFastJsonMap(String json, Object Object) {
		Map<String, Object> map;
		map = JSON.parseObject(json, new TypeReference<Map<String, Object>>() {
		});
		return map;
	}

	public static <T> List<T> getFastJsonList(String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<T>();
		try {
			list = JSON.parseArray(jsonString, cls);
		} catch (Exception e) {
		}
		return list;
	}

	/**
	 * Object 为String
	 * 
	 * @param jString
	 * @return
	 */
	public static List<Map<String, Object>> getlistMaps(String jString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = JSON.parseObject(jString,
					new TypeReference<List<Map<String, Object>>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
