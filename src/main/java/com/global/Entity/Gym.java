package com.global.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gym {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private LocalDate date;
	private Long height;
	private Long weight;
	private Long price;
	private String system_eat;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Long getHeight() {
		return height;
	}
	public void setHeight(Long height) {
		this.height = height;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getSystem_eat() {
		return system_eat;
	}
	public void setSystem_eat(String system_eat) {
		this.system_eat = system_eat;
	}
	@Override
	public String toString() {
		return "Gym [id=" + id + ", name=" + name + ", date=" + date + ", height=" + height + ", weight=" + weight
				+ ", price=" + price + ", system_eat=" + system_eat + "]";
	}
	public Gym(Long id, String name, LocalDate date, Long height, Long weight, Long price, String system_eat) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.height = height;
		this.weight = weight;
		this.price = price;
		this.system_eat = system_eat;
	}
	public Gym() {
		super();
		
	}
	
	
}
