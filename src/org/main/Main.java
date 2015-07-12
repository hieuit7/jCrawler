package org.main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.config.Config;
import org.gui.MainRawler;
import org.model.CrawDocument;

public class Main {
	private static Config config;
	public Main() {
		// TODO Auto-generated constructor stub
		config = new Config();
	}
	
	public static void main(String[] args) {
				
		//check config exist and use it, then use default!!
		config = new Config();
		if(config.has(0)){
			BlockingQueue<CrawDocument>queue = new ArrayBlockingQueue<>(10);
			config.setRegistry(queue);
		}
		
		MainRawler maingui = new MainRawler(config);
		
		maingui.setVisible(true);
	}
	
	
}
