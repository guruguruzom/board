package com.guruguruzom.boader.util;

import java.util.HashMap;

import com.guruguruzom.boader.valueset.ServiceCode;

public class ResultUtil {
	
	public static HashMap<String,Object> ResultToMap(ServiceCode serviceCode, String serviceMsg, Object obj){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> response = new HashMap<String, Object>();
		response = StateToMap(serviceCode,serviceMsg);
		map.put("state", response);
		map.put("result", obj);
		return map;
	}
	
	public static HashMap<String,Object> StateToMap(ServiceCode serviceCode, String serviceMsg){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", serviceCode.getCode());
		map.put("message", serviceMsg);
		return map;
	}
}
