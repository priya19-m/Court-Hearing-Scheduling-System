package com.wipro.chs.util;

public class CourtroomUnavailableException extends Exception{
	public String toString() {
		return "Courtroom is already booked";
	}

}
