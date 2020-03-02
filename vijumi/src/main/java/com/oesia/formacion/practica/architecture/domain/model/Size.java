package com.oesia.formacion.practica.architecture.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Size {
	S(1, "Pequeña"), M(2, "Mediana"), L(3, "Grande"), XL(4, "Muy Grande");

	private final Integer id;
	private final String name;
	private static final Map<Integer, Size> colourCache = new HashMap<>();

	static {
		for (Size size : values()) {
			colourCache.put(size.id, size);
		}
	}

	Size(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Size findById(Integer id) {
		Size sizeResult = null;
		for (Size size : Size.values()) {
			if (size.id == id) {
				sizeResult = size;
				break;
			}
		}
		return sizeResult;
	}
//	}

}
