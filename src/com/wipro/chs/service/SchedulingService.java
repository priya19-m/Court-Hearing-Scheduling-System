package com.wipro.chs.service;
import java.util.ArrayList;
import com.wipro.chs.entity.*;
import com.wipro.chs.util.*;
public class SchedulingService {
	private ArrayList<Case> caseList;
	private ArrayList<Judge> judgeList;
	private ArrayList<Courtroom> roomList;
	private ArrayList<Hearing> hearingList;
	private int count=1;
	public SchedulingService(ArrayList<Case> cases, ArrayList<Judge> judges, ArrayList<Courtroom> rooms, ArrayList<Hearing> hearings) {
		caseList=cases;
		judgeList=judges;
		roomList=rooms;
		hearingList=hearings;
	}
	public boolean validateCase(String caseId) throws InvalidCaseException {
		for(Case c:caseList) {
			if(c.getCashId().equals(caseId)) {
				return true;
			}
		}
		throw new InvalidCaseException();
		
	}
	public boolean checkJudgeAvailability(String judgeId, String date, String timeSlot) throws JudgeUnavailableException {
		for(Hearing h:hearingList) {
			if(h.getJudgeId().equals(judgeId)&&h.getDate().equals(date)&&h.getTimeSlot().equals(timeSlot)) {
				throw new JudgeUnavailableException();
			}
		}
		return true;
	}
	public boolean checkRoomAvailability(String roomId, String date, String timeSlot) throws CourtroomUnavailableException {
		for(Hearing h:hearingList) {
			if(h.getRoomId().equals(roomId)&&h.getDate().equals(date)&&h.getTimeSlot().equals(timeSlot)) {
				throw new CourtroomUnavailableException();
			}
		}
		return true;
	}
	public Hearing scheduleHearing(String caseId, String judgeId, String roomId, String date, String timeSlot) throws Exception{
		validateCase(caseId);
		checkJudgeAvailability(judgeId, date, timeSlot);
		checkRoomAvailability(roomId, date, timeSlot);
		String hearingId="H"+count;
		count++;
		Hearing hearing=new Hearing(hearingId, caseId, judgeId, roomId, date, timeSlot);
		hearingList.add(hearing);
		return hearing;
	}
	public void cancelHearing(String hearingId) throws HearingNotFoundException {
		for(Hearing h:hearingList) {
			if(h.getHearingId().equals(hearingId)) {
				hearingList.remove(h);
				return;
			}
		}
		throw new HearingNotFoundException();
	}
	public void printCaseHearings(String caseId) {
		for(Hearing h:hearingList) {
			if(h.getCaseId().equals(caseId)) {
				System.out.println(
						h.getHearingId()+ " | " +
				        h.getDate() + " | " +
						h.getTimeSlot() + " | " +
				        h.getJudgeId() + " | " +
						h.getRoomId());
			}
		}
	}
	public void printDailySchedule(String date) {
		for(Hearing h:hearingList) {
			if(h.getDate().equals(date)) {
				System.out.println(
						h.getHearingId() + " | " +
						h.getCaseId() + " | " +
						h.getTimeSlot());
			}
		}
	}

}
