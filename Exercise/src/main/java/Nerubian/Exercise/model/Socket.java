package Nerubian.Exercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="sockets")
public class Socket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long socketId;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Long cpuId;
	
	//Generated Constructors

	public Socket() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Socket(Long id, String description, Long cpu) {
		super();
		this.socketId = id;
		this.description = description;
		this.cpuId = cpu;
	}
	

	public Socket(String description, Long cpuId) {
		super();
		this.description = description;
		this.cpuId = cpuId;
	}


	//Generated getters and setters
	public Long getSocketId() {
		return socketId;
	}

	public void setSocketId(Long id) {
		this.socketId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCpu() {
		return cpuId;
	}


	public void setCpu(Long cpu) {
		this.cpuId = cpu;
	}

	// generates Object to String
	@Override
	public String toString() {
		return "Socket [id=" + socketId + ", description=" + description + ", cpu=" + cpuId + "]";
	}
	
	public JSONObject toJSONObject() {
		JSONObject jo = new JSONObject();
		jo.put("id", getSocketId());
		jo.put("description", getDescription());
		jo.put("cpu", getCpu());
		return jo;
	}
}
