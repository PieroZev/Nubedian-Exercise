package Nerubian.Exercise.model;

import javax.persistence.*;

import org.json.JSONObject;

@Entity
@Table(name = "cpus")
public class CPU {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String brand;

	@Column(nullable = false)
	private String model;

	@Column(nullable = true)
	private double clockSpeed;

	@Column(nullable = true)
	private int numberOfCores;

	@Column(nullable = true)
	private int numberOfThreads;

	@Column(nullable = true)
	private double tdp;

	@Column(nullable = true)
	private double price;

	//Constructors for CPU
	public CPU() {
		
	}

	public CPU(String brand, String model, double clockSpeed, int numberOfCores,
			int numberOfThreads, double tdp, double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.clockSpeed = clockSpeed;
		this.numberOfCores = numberOfCores;
		this.numberOfThreads = numberOfThreads;
		this.tdp = tdp;
		this.price = price;
	}

	public CPU(Long id, String brand, String model, double clockSpeed, int numberOfCores,
			int numberOfThreads, double tdp, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.clockSpeed = clockSpeed;
		this.numberOfCores = numberOfCores;
		this.numberOfThreads = numberOfThreads;
		this.tdp = tdp;
		this.price = price;
	}

	//generated getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public int getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(int numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public double getTdp() {
		return tdp;
	}

	public void setTdp(double tdp) {
		this.tdp = tdp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//Object to String
	
	@Override
	public String toString() {
		return "CPU [id=" + id + ", brand=" + brand + ", model=" + model + ", clockSpeed="
				+ clockSpeed + ", numberOfCores=" + numberOfCores + ", numberOfThreads=" + numberOfThreads + ", tdp="
				+ tdp + ", price=" + price + "]";
	}
	
	public JSONObject toJSONObject() {
		JSONObject jo = new JSONObject();
		jo.put("id", getId());
		jo.put("brand", getBrand());
		jo.put("model", getModel());
		jo.put("clockspeed",getClockSpeed());
		jo.put("numberOfCores", getNumberOfCores());
		jo.put("numberOfThreads", getNumberOfThreads());
		jo.put("tdp", getTdp());
		jo.put("price", getPrice());
		return jo;
	}
		
}
