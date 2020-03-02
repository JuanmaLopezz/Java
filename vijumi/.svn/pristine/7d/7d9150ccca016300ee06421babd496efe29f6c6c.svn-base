package com.oesia.formacion.practica.architecture.communications.messages.put;

import com.oesia.formacion.practica.architecture.domain.model.Colour;
import com.oesia.formacion.practica.architecture.domain.model.Size;
import com.oesia.formacion.practica.architecture.persistence.entities.vendor.VendorData;

public class PutMessageInformation {

	private int idWorkOrder;
	private int idVendor;
	private int idArticle;
	private String descriptionArticle;
	private int idColor;
	private int idTalla;
	private int numUds;

	private Size talla;
	private Colour color;
	private VendorData vendor;

	public PutMessageInformation(Builder builder) {
		this.descriptionArticle = builder.descriptionArticle;
		this.idArticle = builder.idArticle;
		this.idColor = builder.idColor;
		this.idTalla = builder.idTalla;
		this.idVendor = builder.idVendor;
		this.idWorkOrder = builder.idWorkOrder;
		this.numUds = builder.numUds;
		this.talla = builder.talla;
		this.color = builder.color;
		this.vendor = builder.vendor;

	}

	public int getIdWorkOrder() {
		return idWorkOrder;
	}

	public int getIdVendor() {
		return idVendor;
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

	public Size getTalla() {
		return talla;
	}

	public Colour getColor() {
		return color;
	}

	public VendorData getVendor() {
		return vendor;
	}

	public static class Builder {
		private int idWorkOrder;
		private int idVendor;
		private int idArticle;
		private String descriptionArticle;
		private int idColor;
		private int idTalla;
		private int numUds;

		private Size talla;
		private Colour color;
		private VendorData vendor;

		public PutMessageInformation build() {
			return new PutMessageInformation(this);
		}

		public void idWorkOrder(int idWorkOrder) {
			this.idWorkOrder = idWorkOrder;
		}

		public void idVendor(int idVendor) {
			this.idVendor = idVendor;
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

		public void talla(Size talla) {
			this.talla = talla;
		}

		public void color(Colour color) {
			this.color = color;
		}

		public void vendor(VendorData vendor) {
			this.vendor = vendor;
		}
	}

}
