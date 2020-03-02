package com.oesia.formacion.practica.architecture.communications.messages.stock;

public class StockMessageInformation {

	private int idArticle;
	private String descriptionArticle;
	private int idColor;
	private int idTalla;
	private int numUds;

	public StockMessageInformation(Builder builder) {
		this.idArticle = builder.idArticle;
		this.descriptionArticle = builder.descriptionArticle;
		this.idColor = builder.idColor;
		this.idTalla = builder.idTalla;
		this.numUds = builder.numUds;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public String getDescriptionArticle() {
		return descriptionArticle;
	}

	public int getIdColor() {
		return idColor;
	}

	public int getIdTalla() {
		return idTalla;
	}

	public int getNumUds() {
		return numUds;
	}

	public static class Builder {
		private int idArticle;
		private String descriptionArticle;
		private int idColor;
		private int idTalla;
		private int numUds;

		public StockMessageInformation build() {
			return new StockMessageInformation(this);
		}

		public void idArticle(int idArticle) {
			this.idArticle = idArticle;
		}

		public void descriptionArticle(String descriptionArticle) {
			this.descriptionArticle = descriptionArticle;
		}

		public void idColor(int idColor) {
			this.idColor = idColor;
		}

		public void idTalla(int idTalla) {
			this.idTalla = idTalla;
		}

		public void numUds(int numUds) {
			this.numUds = numUds;
		}
	}
}
