package org.parser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;









import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.model.CrawNode;
import org.model.Html;



public class DocumentParser {

	private Document doc;




	public DocumentParser(Document doc) {

		this.doc = doc;
	}
	public void parseTree(DefaultMutableTreeNode treeNode,Element node){
		//System.out.println(node.nodeName()+": "+node.toString());
		CrawNode parent = (CrawNode)treeNode.getUserObject();
		Elements els = node.children();

		if(els.size()> 0){
			for (int i = 0; i < els.size(); i++) {
				CrawNode craw = new CrawNode(els.get(i));
				DefaultMutableTreeNode child = new DefaultMutableTreeNode(craw);
				treeNode.add(child);
				parseTree(child, els.get(i));
			}
		}else{
			CrawNode craw = new CrawNode(node);
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(craw);
			treeNode.add(child);
//			String textNode = node.text();
//			if(!textNode.trim().isEmpty()){
//				DefaultMutableTreeNode child = new DefaultMutableTreeNode(node.text());
//				treeNode.add(child);
//			}else{
//				CrawNode craw = new CrawNode(node);
//				if(!craw.getTextNode().trim().isEmpty()){
//					DefaultMutableTreeNode child = new DefaultMutableTreeNode(craw.getTextNode());
//					treeNode.add(child);
//				}
//			}


		}
	}

}
