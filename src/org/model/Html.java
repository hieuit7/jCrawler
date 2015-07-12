package org.model;

import java.util.ArrayList;
import java.util.Map;

public class Html {
	private String name;
	private Map<String, ArrayList<String>> attr;
	private String content;
	private int type;
	
	public Html() {
		// TODO Auto-generated constructor stub
		this.type = 1;
	}
	
	public Html(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, ArrayList<String>> getAttr() {
		return attr;
	}

	public void setAttr(Map<String, ArrayList<String>> attr) {
		this.attr = attr;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret = "sss";
		if(type ==1){
			ret = this.name;
			
		}else if(type == 2){
			if (attr.containsKey("id")) {
				ArrayList<String> id = attr.get("id");
				ret = id.get(0);
			}else{
				ret = this.name;
			};
		}else{
			if (attr.containsKey("class")) {
				ArrayList<String> id = attr.get("class");
				ret = id.get(0);
			}else{
				ret = this.name;
			};
		}
		return ret;
	}
	
	
	
}
