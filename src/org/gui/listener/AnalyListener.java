package org.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import org.config.Config;
import org.jsoup.nodes.Document;
import org.model.CrawDocument;
import org.net.Producer;

public class AnalyListener implements ActionListener{

	private Config config;
	private String url;
	
	
	public AnalyListener(Config config,String url) {

		this.config = config;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		BlockingQueue<Document>queue = (BlockingQueue<Document>)this.config.getRegistry("queue");
		Producer anlyz = new Producer(queue,url);
	}

	
}
