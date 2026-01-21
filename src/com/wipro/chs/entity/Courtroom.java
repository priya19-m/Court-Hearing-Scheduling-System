package com.wipro.chs.entity;

public class Courtroom {
	private String roomId;
	private int capacity;
	public Courtroom(String roomId, int capacity) {
		this.roomId=roomId;
		this.capacity=capacity;
	}
	public String getRoomId() {
		return roomId;
	}
	public int getCapacity() {
		return capacity;
	}
}
