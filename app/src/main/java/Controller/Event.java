package Controller;

import java.util.Date;

public class Event {
    private int attendees;
    private String shortInroduction;
    private Date date;
    private String eventName;
    private String address;

    public Event(int attendees, String shortInroduction, Date date, String eventName, String address) {
        this.attendees = attendees;
        this.shortInroduction = shortInroduction;
        this.date = date;
        this.eventName = eventName;
        this.address = address;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public String getShortInroduction() {
        return shortInroduction;
    }

    public void setShortInroduction(String shortInroduction) {
        this.shortInroduction = shortInroduction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

