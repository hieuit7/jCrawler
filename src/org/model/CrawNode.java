package org.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class CrawNode {
	
	private Element el;
	
	private int id;
	private String tag;
	private HashMap<String, String> attrs;
	private String textNode;
	
	private String path;
	
	public String getPath() {
		return path;
	}




	public void setPath(String path) {
		this.path = path;
	}




	public Element getEl() {
		return el;
	}




	public void setEl(Element el) {
		this.el = el;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTag() {
		return tag;
	}




	public void setTag(String tag) {
		this.tag = tag;
	}




	public HashMap<String, String> getAttrs() {
		return attrs;
	}




	public void setAttrs(HashMap<String, String> attrs) {
		this.attrs = attrs;
	}




	public String getTextNode() {
		return textNode;
	}




	public void setTextNode(String textNode) {
		this.textNode = textNode;
	}




	public CrawNode(Element el) {
		
		
		this.el = el;
		this.tag = el.tagName();
		this.attrs = new HashMap<>();
		
		this.textNode = el.text();
		String path = el.cssSelector();		
		this.path = path;
		Attributes attrs = el.attributes();
		for (Attribute attribute : attrs) {
			String key = attribute.getKey();
			String value = attribute.getValue();
			this.attrs.put(key, value);
		}
		
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String attr = "";
		Set<String> set = this.attrs.keySet();
		for (String string : set) {
			attr = attr+" "+string+"=\""+this.attrs.get(string)+"\"";
		}
		return "<"+tag+" "+attr+">";
	}
	
	
	
	
	
	
	
	

}
