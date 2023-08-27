package com.tyss.foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tyss.foodapp.util.Ailability;
import com.tyss.foodapp.util.FoodType;

@Entity
public class FoodProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Enumerated(EnumType.STRING)
	private FoodType type;
	private String about;
	@Enumerated(EnumType.STRING)
	private Ailability availabilty;
	private double price;
	@ManyToOne
	@JoinColumn
	private Menu menu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Ailability getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(Ailability availabilty) {
		this.availabilty = availabilty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "FoodProduct [id=" + id + ", name=" + name + ", type=" + type + ", about=" + about + ", availabilty="
				+ availabilty + ", price=" + price +  "]";
	}
	
}
