package org.config;

import java.util.ArrayList;

public class Config {
	/**
	 * STORE CONFIG
	 */
	public static final int STORE_MYSQL = 1;
	public static final int STORE_MONGDB = 2;
	public static final int STORE_XML = 3;
	public static final int STORE_MSSQL = 4;
	public static final int STORE_FILE = 5;

	/**
	 * STEP
	 */
	public static final int STEP_STEP = 1;
	public static final boolean STEP_AUTO = true;
	
	/**
	 * DETERMINE
	 */
	public static final int DETERMINE_ID = 1;
	public static final int DETERMINE_SLUG = 2;
	
	
	
	public static int store = STORE_MYSQL;
	public static int step = STEP_STEP;
	public static boolean auto = STEP_AUTO;
	public static int determine = DETERMINE_ID;
	
	private ArrayList<Object>registry = new ArrayList();
	
	public Config(int store,int step,boolean auto,int determine) {
		// TODO Auto-generated constructor stub
		Config.store = store;
		Config.step = step;
		Config.auto = auto;
		Config.determine = determine;
	}
	public Config(int store,int step,boolean auto) {
		// TODO Auto-generated constructor stub
		Config.store = store;
		Config.step = step;
		Config.auto = auto;
		
	}
	public Config(int store,int step) {
		// TODO Auto-generated constructor stub
		Config.store = store;
		Config.step = step;		
	}
	public Config(int store) {
		// TODO Auto-generated constructor stub
		Config.store = store;		
	}
	public Config() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean has(int index) {
		if(registry.size() <= index && index < 0){
			return false;
		}
		return true;
	}
	public int setRegistry(Object obj){
		registry.add(obj);
		return registry.size();
	}
	public Object getRegistry(int index) {
		
		return registry.get(index);
	}
	
	
	
	public void setRegistry(ArrayList<Object> registry) {
		this.registry = registry;
	}
	
}
