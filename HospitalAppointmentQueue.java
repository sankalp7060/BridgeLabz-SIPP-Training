import java.util.*;
class Appointment {
    String patientName;
    String doctorName;
    String timeSlot;

    public Appointment(String patientName, String doctorName, String timeSlot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }
}

class AppointmentQueue<T extends Appointment> {
    Queue<T> queue = new LinkedList<>();

    public void addAppointment(T appointment) {
        queue.offer(appointment);
    }

    public T serveNext() {
        return queue.poll();
    }

    public T viewNext() {
        return queue.peek();
    }
}

public class HospitalAppointmentQueue {
    public static void main(String[] args) {
        AppointmentQueue<Appointment> q = new AppointmentQueue<>();
        q.addAppointment(new Appointment("John", "Dr. Smith", "10:00 AM"));
        q.addAppointment(new Appointment("Jane", "Dr. Adams", "10:30 AM"));

        System.out.println("Next: " + q.viewNext().patientName);
        System.out.println("Served: " + q.serveNext().patientName);
    }
}