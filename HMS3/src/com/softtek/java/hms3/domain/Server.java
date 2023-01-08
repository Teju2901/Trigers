package com.softtek.java.hms3.domain;

public class Server extends Employee {
	int serverId;
	int orderId;
	
	
	  Server(int serverId,int orderId){
		  this.serverId=serverId;
		  this.orderId=orderId;
	  }
	  
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	

}
