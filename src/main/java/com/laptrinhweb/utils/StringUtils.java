package com.laptrinhweb.utils;

public class StringUtils {
	//đây là lớp sử dụng logic cho giá trị truyền vào có hay không.nếu rỗng thì sao nếu không rỗng thì sao
	//
public static boolean isNullOrEmpty( String value ) {
	//nếu giá trị chuyền vào mà isnullorempty thi trả về false.
	//giá trị chuyền vào khác null or khác rỗng thi trả về false
	//nếu là isnullorempty thi trả về true
	
	if (value!=null && value!="") {
		return false;
	}
	return true;
	
}
}
