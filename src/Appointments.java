import java.time.LocalDateTime;

public class Appointments {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        System.out.println(scheduler.schedule("12/25/2019 13:45:00"));
        var hoursFromNow = LocalDateTime.now().plusHours(3);
        boolean hasMeetingPassed = scheduler.hasPassed(hoursFromNow);
        System.out.printf("Has appointment already passed: %s%n", hasMeetingPassed);
        var hoursAgo = LocalDateTime.now().minusHours(12);
        hasMeetingPassed = scheduler.hasPassed(hoursAgo);
        System.out.printf("Has appointment already passed: %s%n", hasMeetingPassed);
        boolean afternoonAppointment = scheduler.isAfternoonAppointment(LocalDateTime.of(2019, 03, 29, 15, 0, 0));
        System.out.printf("Is appointment in the afternoon %s%n", afternoonAppointment);
        afternoonAppointment = scheduler.isAfternoonAppointment(LocalDateTime.of(2019, 03, 29, 10, 0, 0));
        System.out.printf("Is appointment in the afternoon %s%n", afternoonAppointment);
        String appointmentMessage = scheduler.getDescription(LocalDateTime.of(2019, 03, 29, 15, 0, 0));
        System.out.println(appointmentMessage);
        System.out.printf("Anniversary date: %s %n", scheduler.getAnniversaryDate());
    }
}
