package com.oesia.formacion.practica.architecture.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Colour {
	BLUE(1, "Azul"), WHITE(2, "Blanco"), BLACK(3, "Negro");

	private final Integer id;
	private final String name;
	private static final Map<Integer, Colour> colourCache = new HashMap<>();

	static {
		for (Colour colour : values()) {
			colourCache.put(colour.id, colour);
		}
	}

	Colour(Integer id, String colour) {
		this.id = id;
		this.name = colour;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Colour findById(Integer id) {
		Colour colorResult = null;
		for (Colour color : Colour.values()) {
			if (color.id == id) {
				colorResult = color;
				break;
			}
		}
		return colorResult;
	}
}
