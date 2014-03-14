package common.constant;

import java.util.Map;
import java.util.HashMap;

public class Color {
	public static Map<String, String> color;
	
	static{
		color = new HashMap<String, String>();
		
		color.put("tip1", "black");
		color.put("tip2", "white");
	}

}
