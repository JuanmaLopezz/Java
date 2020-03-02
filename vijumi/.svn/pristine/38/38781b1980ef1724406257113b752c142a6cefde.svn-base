package com.oesia.formacion.practica.architecture.domain.model;

import com.oesia.formacion.practica.architecture.persistence.entities.vendor.VendorData;

public class Article {

	private VendorData vendordata;
	private int articleId;
	private String description;
	private Colour colour;
	private Size size;
	private int numUnit;

	public Article (Builder builder) {
		this.vendordata = builder.vendordata;
		this.articleId = builder.articleId;
		this.description = builder.description;
		this.colour = builder.colour;
		this.size = builder.size;
		this.numUnit = builder.numUnit;
	}

	public VendorData getVendordata() {
		return vendordata;
	}

	public int getArticleId() {
		return articleId;
	}

	public String getDescription() {
		return description;
	}

	public Colour getColour() {
		return colour;
	}

	public Size getSize() {
		return size;
	}

	public int getNumUnit() {
		return numUnit;
	}

	@Override
	public String toString() {
		return "Article [vendordata=" + vendordata + ", ArticleId=" + articleId
				+ ", description=" + description + ", colour=" + colour + ", size=" + size + ", NumUnit=" + numUnit
				+ "]";
	}
	
	public static class Builder {
		
		private VendorData vendordata;
		private int articleId;
		private String description;
		private Colour colour;
		private Size size;
		private int numUnit;
		
		public Article build() {
			return new Article(this);
		}
		
		public void vendordata(VendorData vendorData) {
			this.vendordata = vendorData;
		}
		
		public void articleId(Integer articleId) {
			this.articleId = articleId;
		}
		
		public void description(String description) {
			this.description = description;
		}
		
		public void colour(Colour colour) {
			this.colour = colour;
		}
		
		public void size(Size size) {
			this.size = size;
		}
		
		public void numUnit(Integer numUnit) {
			this.numUnit = numUnit;
		}
	}
}
