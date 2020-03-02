package com.oesia.formacion.practica.architecture.communications.messages.stock;

public class StockMessageInformation {

	private int articleId;
	private String description;
	private int colourId;
	private int sizeId;
	private int numUnit;
	
	public StockMessageInformation(Builder builder) {
		this.articleId = builder.articleId;
		this.description = builder.description;
		this.colourId = builder.colourId;
		this.sizeId = builder.sizeId;
		this.numUnit = builder.numUnit;
	}

	public int getArticleId() {
		return articleId;
	}

	public String getDescription() {
		return description;
	}

	public int getColourId() {
		return colourId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public int getNumUnit() {
		return numUnit;
	}

	public static class Builder {
		private int articleId;
		private String description;
		private int colourId;
		private int sizeId;
		private int numUnit;
		
		public StockMessageInformation build() {
			return new StockMessageInformation(this);
		}
	}
	
	public void articleId(int articleId) {
		this.articleId = articleId;
	}
	
	public void description(String description) {
		this.description = description;
	}
	
	public void colourId(int colourId) {
		this.colourId = colourId;
	}
	
	public void sizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	
	public void numUnit(int numUnit) {
		this.numUnit = numUnit;
	}
}
