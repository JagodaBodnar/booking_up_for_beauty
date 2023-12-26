import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int getHour = appointmentDate.getHour();
        if (getHour >= 12 && getHour < 18) {
            return true;
        }
        return false;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return String.format("You have an appointment on %s, %s %d, %d, at %s.",
                transformCasing(String.valueOf(appointmentDate.getDayOfWeek()).toLowerCase()),
                transformCasing(String.valueOf(appointmentDate.getMonth()).toLowerCase()),
                appointmentDate.getDayOfMonth(), appointmentDate.getYear(),
                appointmentDate.format(DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH)));
    }

    public String transformCasing(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(2023, 9, 15);
    }
}
