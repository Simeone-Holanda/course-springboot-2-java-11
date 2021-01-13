package com.empresa.webservices.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	// para atribuirmos valores aos tipos enumerados pe necessario um construtor da classe
	// sabendo que esse construtor tem q ser privado é necessario criar metodo para pegar os
	// codigos, então foi criado um metodo getCode e tambem um metodo para pegar o o tipo enum
	// por codigo.
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value: OrderStatus.values()) {
			if( value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
