import java.util.Calendar;

public record HeartRates(String firstName, String lastName, int birthMonth, int birthDay, int birthYear) {

    // Method to calculate age
    public int calculateAge() {

        // Finds what time it is now, to figure out how old you are.
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int currentMonth = now.get(Calendar.MONTH) + 1;
        int currentDay = now.get(Calendar.DAY_OF_MONTH);

        // Checks to make sure the user has or has not had their birthday yet this year
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
