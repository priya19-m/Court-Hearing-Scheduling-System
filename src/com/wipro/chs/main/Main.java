package com.wipro.chs.main; 
import java.util.ArrayList; 
import com.wipro.chs.entity.*; 
import com.wipro.chs.service.SchedulingService; 
import com.wipro.chs.util.*; 
public class Main { 
public static void main(String[] args) { 
ArrayList<Case> cases = new ArrayList<>(); 
cases.add(new Case("C001", "Property Dispute", "Arun", "Mahesh")); 
cases.add(new Case("C002", "Cheque Bounce", "Sita", "Ravi")); 
ArrayList<Judge> judges = new ArrayList<>(); 
judges.add(new Judge("J001", "Justice Sharma")); 
judges.add(new Judge("J002", "Justice Reddy")); 
        ArrayList<Courtroom> rooms = new ArrayList<>(); 
        rooms.add(new Courtroom("R101", 100)); 
        rooms.add(new Courtroom("R102", 80)); 
        ArrayList<Hearing> hearings = new ArrayList<>(); 
        SchedulingService service = new SchedulingService(cases, judges, rooms, hearings); 
        try { 
            Hearing h1 = service.scheduleHearing("C001", "J001", "R101", "2025-06-12", "10:00 AM - 11:00 AM"); 
            System.out.println("Hearing Scheduled: " + h1.getHearingId()); 
            System.out.println("\n--- Case Hearings (C001) ---"); 
            service.printCaseHearings("C001"); 
            System.out.println("\nCancelling hearing..."); 
            service.cancelHearing(h1.getHearingId()); 
            System.out.println("Hearing Cancelled!"); 
        } catch (InvalidCaseException | JudgeUnavailableException | 
                 CourtroomUnavailableException | HearingNotFoundException | 
                 SchedulingConflictException ex) { 
            System.out.println(ex); 
        } 
        catch (Exception ex) { 
            System.out.println("Unexpected Error: " + ex); 
        } 
    } 
} 
