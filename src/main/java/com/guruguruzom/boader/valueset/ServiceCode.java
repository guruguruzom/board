package com.guruguruzom.boader.valueset;

public enum ServiceCode {
	SUCCESS_CODE(100,"SUCCESS"),
	FAILER_CODE(101,"FAILER");
	
	Integer code = null;
	String message = null;
	
	ServiceCode(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
//	public static ServiceCode getEnumFromString(Class<ServiceCode> d, String value) throws Exception {
//		
//		for(ServiceCode ds : d.getEnumConstants()) {
//			if(ds.getMessage().equals(value)) {
//				return ds;
//			}
//		}
//		
//		throw new Exception("Invalid ServiceCode");
//	}
}
