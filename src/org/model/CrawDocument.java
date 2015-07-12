package org.model;

import javax.swing.tree.DefaultMutableTreeNode;

public class CrawDocument {
	private DefaultMutableTreeNode tagsModel,idsModel,clssModel;

	
	public CrawDocument() {
		// TODO Auto-generated constructor stub
		this.tagsModel = new DefaultMutableTreeNode("No tags found");
		this.idsModel = new DefaultMutableTreeNode("No id found");
		this.clssModel = new DefaultMutableTreeNode("No class found");
	}
	
	public CrawDocument(DefaultMutableTreeNode tagsModel,
			DefaultMutableTreeNode idsModel, DefaultMutableTreeNode clssModel) {
		this.tagsModel = tagsModel;
		this.idsModel = idsModel;
		this.clssModel = clssModel;
	}

	public DefaultMutableTreeNode getTagsModel() {
		return tagsModel;
	}

	public void setTagsModel(DefaultMutableTreeNode tagsModel) {
		this.tagsModel = tagsModel;
	}

	public DefaultMutableTreeNode getIdsModel() {
		return idsModel;
	}

	public void setIdsModel(DefaultMutableTreeNode idsModel) {
		this.idsModel = idsModel;
	}

	public DefaultMutableTreeNode getClssModel() {
		return clssModel;
	}

	public void setClssModel(DefaultMutableTreeNode clssModel) {
		this.clssModel = clssModel;
	}
	
	
}
