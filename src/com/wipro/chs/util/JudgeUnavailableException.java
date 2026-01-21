package com.wipro.chs.util;

public class JudgeUnavailableException extends Exception {
    public String toString() {
    	return "Judge already has a hearing at this time";
    }
}
