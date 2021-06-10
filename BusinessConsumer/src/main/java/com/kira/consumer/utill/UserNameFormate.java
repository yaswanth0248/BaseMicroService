package com.kira.consumer.utill;

import org.springframework.stereotype.Component;

@Component
public class UserNameFormate {
	
	public String withoutSpace(String name)
	{
		String str = name.replaceAll("\\s", "");
		
		return str;
	}
	
	


}
