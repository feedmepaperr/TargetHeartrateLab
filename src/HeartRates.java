import java.util.Calendar;

public class HeartRates {
    private final String firstName;
    private final String lastName;
    private final int birthMonth;
    private final int birthDay;
    private final int birthYear;

    public HeartRates(String firstName, String lastName, int birthMonth, int birthDay, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    // Getter methods
    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public int birthMonth() {
        return birthMonth;
    }

    public int birthDay() {
        return birthDay;
    }

    public int birthYear() {
        return birthYear;
    }

    // Method to calculate age
    public int calculateAge() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int currentMonth = now.get(Calendar.MONTH) + 1;
        int currentDay = now.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - birthYear;
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }
        return age;
    }

    // Method to calculate maximum heart rate
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    // Method to calculate target heart rate range
    public String calculateTargetHeartRateRange() {
        int maxHeartRate = calculateMaxHeartRate();
        int lowerBound = (int) (maxHeartRate * 0.5);
        int upperBound = (int) (maxHeartRate * 0.85);
        return lowerBound + " - " + upperBound;
    }
}
