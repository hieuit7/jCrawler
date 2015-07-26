package org.net;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.model.CrawDocument;
import org.parser.DocumentParser;

public class Producer implements Runnable{


	private BlockingQueue<Document>queue;

	private String url;


	public Producer(BlockingQueue<Document> queue,String url) {

		this.queue = queue;
		this.url = url;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Connection con = HttpConnection.connect(url);
		try {
			Response res = con.execute();
			if(res.statusCode() == 200){
				try {
					Document doc = con.get();
					
					this.queue.put(doc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
