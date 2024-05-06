public class HeartRateCalculator {
    public static void calculateHeartRate(String firstName, String lastName, String birthMonth,
                                          String birthDay, String birthYear, HeartRateGUI gui) {
        int birthMonthValue;
        int birthDayValue;
        int birthYearValue;

        // Validation and parsing
        try {
            // Calls to parseMonth, which is below.
            birthMonthValue = parseMonth(birthMonth);
        } catch (IllegalArgumentException ex) {
            gui.displayErrorMessage(ex.getMessage());
            return;
        }

        try {
            // Since I only expect number values for birth day, I don't need another method.
            birthDayValue = Integer.parseInt(birthDay);
            if (birthDayValue < 1 || birthDayValue > 31) {
                gui.displayErrorMessage("Birth day must be between 1 and 31");
                return;
            }
        } catch (NumberFormatException ex) {
            gui.displayErrorMessage("Birth day must be a number");
            return;
        }

        try {
            birthYearValue = Integer.parseInt(birthYear);
            // I am assuming here the user is not a baby or long since dead. I feel like this is safe to assume.
            if (birthYearValue < 1900 || birthYearValue > 2023) {
                gui.displayErrorMessage("Please enter your real birth year.");
                return;
            }
        } catch (NumberFormatException ex) {
            gui.displayErrorMessage("Birth year must be a number");
            return;
        }

        // Create HeartRates object
        HeartRates person = new HeartRates(firstName, lastName, birthMonthValue, birthDayValue, birthYearValue);

        // Display heart rate information, calls HeartRateGUI
        gui.displayHeartRateInfo(
                "Name: " + person.firstName() +
                        " " + person.lastName() + "\n" +
                        "Date of Birth: " + person.birthMonth() +
                        "/" + person.birthDay() + "/" +
                        person.birthYear() + "\n" +
                        "Age: " + person.calculateAge() + " years\n" +
                        "Maximum Heart Rate: " + person.calculateMaxHeartRate() + " bpm\n" +
                        "Target Heart Rate Range: " + person.calculateTargetHeartRateRange() + " bpm"
        );
    }

    // I really wanted it to allow you to type the full name of the month instead of just using numbers,
    // but I also allowed you to use numbers if you'd like as well.
    private static int parseMonth(String input) {
        // Check if input contains only digits
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (isNumeric) {
            int numericMonth = Integer.parseInt(input);
            if (numericMonth >= 1 && numericMonth <= 12) {
                return numericMonth;
            } else {
                throw new IllegalArgumentException("Invalid input for birth month");
            }
        } else {
            // Extract the first 3 chars and convert to lowercase, then compare to check month.
            String monthAbbreviation = input.substring(0, Math.min(input.length(), 3)).toLowerCase();
            return switch (monthAbbreviation) {
                case "jan" -> 1;
                case "feb" -> 2;
                case "mar" -> 3;
                case "apr" -> 4;
                case "may" -> 5;
                case "jun" -> 6;
                case "jul" -> 7;
                case "aug" -> 8;
                case "sep" -> 9;
                case "oct" -> 10;
                case "nov" -> 11;
                case "dec" -> 12;
                default -> throw new IllegalArgumentException("Invalid input for birth month");
            };
        }
    }

    // End of class
}
