package com.xionglian.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemInfo {
	public static final String sep = File.separator;
	//读取系统变量Kylin_Dragon_Conf
	public static final String Kylin_Dragon_Conf = System.getenv("Kylin_Dragon_Conf");
	public static final String TeaHouse = Kylin_Dragon_Conf + sep + "TeaHouse";
	public static final String File_Conf = TeaHouse + sep + "file.propertise";
	public static final String UPLOADPATH = SystemInfo.getPropertise(SystemInfo.File_Conf,"upload_path");

	
	//微信公众号相关
	public static final String APP_ID = "wxda0a067c9597cbd1";
	public static final String APP_SECRET = "a41f982b6e72cd1df223794fd32b25ab";
	public static final String DEBUG_APP_ID = "wxd84e884eccffa8fb";
	public static final String DEBUG_APP_SECRET = "63ab583fbf9088ccf10ab15280b134ba";
	public static final String KEY = "tqQr3IvttQ1DrtC7dPop9fP7TJZ4gjgi";
	
	public static String getPropertise(String Path, String key) {
		Properties props =  new  Properties();
		try {
			FileInputStream in = new FileInputStream(Path);
			props.load(in);
			in.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return props.getProperty(key);
	}
}
