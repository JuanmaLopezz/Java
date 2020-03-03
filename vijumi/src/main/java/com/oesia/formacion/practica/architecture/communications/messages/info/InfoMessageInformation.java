package com.oesia.formacion.practica.architecture.communications.messages.info;

import java.util.List;

public class InfoMessageInformation {

//	private int idArticle;
	private List<String> articleIdsList;

	public InfoMessageInformation(Builder builder) {
//		this.idArticle = builder.idArticle;
		this.articleIdsList = builder.articleIdsList;
	}

//	public int getIdArticle() {
//		return idArticle;
//	}
	
	public List<String> getArticleIdsList() {
		return articleIdsList;
	}

	public static class Builder {
//		private int idArticle;
		private List<String> articleIdsList;

		public InfoMessageInformation build() {
			return new InfoMessageInformation(this);
		}

//		public void idArticle(int idArticle) {
//			this.idArticle = idArticle;
//		}
		
		public void articleIdsList(List<String> articleIdsList) {
			this.articleIdsList = articleIdsList;
		}

	}
}
