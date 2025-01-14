import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class ClockingSystem {
    Map<Integer, Employee> employees;
    Map<Integer, TimeEntry> timeEntries;

    public ClockingSystem() {
        this.employees = new HashMap<>();
        this.timeEntries = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public boolean clockIn(int employeeId, String code) throws Exception {
        if (!validateCode(employeeId, code)) {
            throw new Exception("Invalid access code.");
        }
        
        Employee emp = employees.get(employeeId);

        // Check if employee is on schedule for the day
        if (emp.isScheduledToday()) {
            
            // Check if employee already clocked in
            TimeEntry entry = timeEntries.get(employeeId);
            if (entry == null || entry.getClockedIn() == null) { // Assuming null means not yet clocked in
                entry = new TimeEntry(emp.getId());
                entry.setClockedIn(LocalTime.now());
                timeEntries.put(employeeId, entry);
                return true;
            } else {
                throw new Exception("Employee is already clocked in.");
            }
        } else {
            throw new Exception("Employee not scheduled for today.");
        }
    }

    public boolean clockOut(int employeeId, String code) throws Exception {
        if (!validateCode(employeeId, code)) {
            throw new Exception("Invalid access code.");
        }
        
        Employee emp = employees.get(employeeId);

        // Check if employee is on schedule for the day
        if (emp.isScheduledToday()) {
            
            TimeEntry entry = timeEntries.get(employeeId);
            if (entry != null && entry.getClockedIn() != null) { // If already clocked in
                if (entry.getClockedOut() == null) {
                    entry.setClockedOut(LocalTime.now());
                    return true;
                } else {
                    throw new Exception("Employee has already clocked out.");
                }
            } else {
                throw new Exception("Employee is not currently clocked in.");
            }
        } else {
            throw new Exception("Employee not scheduled for today.");
        }
    }

    private boolean validateCode(int employeeId, String code) {
        Employee emp = employees.get(employeeId);
        // Check if the provided code matches the one stored for this employee
        return (emp != null && emp.accessCode.equals(code));
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class Employee {
    int id;
    String accessCode;
    ShiftSchedule schedule;

    public Employee(int id, String accessCode, ShiftSchedule schedule) {
        this.id = id;
        this.accessCode = accessCode;
        this.schedule = schedule;
    }
    
    public int getId() {
        return id;
    }

    public boolean isScheduledToday() {
        // Check if the current day is in the schedule
        return schedule.isScheduledToday();
    }
}

class ShiftSchedule {
    private DayOfWeek dayOfWeek;

    public ShiftSchedule(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isScheduledToday() {
        return LocalDate.now().getDayOfWeek().equals(dayOfWeek);
    }
}

class TimeEntry {
    int employeeId;
    LocalTime clockedIn, clockedOut;

    public TimeEntry(int id) {
        this.employeeId = id;
    }

    public LocalTime getClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(LocalTime time) {
        this.clockedIn = time;
    }

    public LocalTime getClockedOut() {
        return clockedOut;
    }

    public void setClockedOut(LocalTime time) {
        this.clockedOut = time;
    }
}