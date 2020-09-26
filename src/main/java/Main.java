import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final String FROM_YEAR = "fromYear";
    private static final String TO_YEAR = "toYear";

    public static void main(String[] args) {
        Map<String, Integer> years = enterYears();
        validateYears(years.get(FROM_YEAR), years.get(TO_YEAR));
        printBonusDatesBetween(years.get(FROM_YEAR), years.get(TO_YEAR));
    }

    private static Map<String, Integer> enterYears() {
        Map<String, Integer> years = new HashMap<>();
        Scanner year = new Scanner(System.in);
        System.out.println("Enter from year: ");
        years.put(FROM_YEAR, year.nextInt());
        System.out.println("Enter to year: ");
        years.put(TO_YEAR, year.nextInt());
        return years;
    }

    private static void validateYears(int fromYear, int toYear) {
        if (fromYear < 1000 && toYear <1000 && fromYear > toYear) {
            System.out.println("Incorrect years, please, try again!");
        }
    }

    private static void printBonusDatesBetween(int fromYear, int toYear) {
        getYearsBetween(fromYear, toYear).forEach(Main::printDate);
    }

    private static List<Integer> getYearsBetween(int fromYear, int toYear) {
        return IntStream.range(fromYear, toYear).boxed().collect(Collectors.toList());
    }

    private static void printDate(Integer date) {
        StringBuilder year = new StringBuilder(String.valueOf(date)).reverse();
        String month = year.substring(0, 2);
        String day = year.substring(2, year.length());
        if (Integer.parseInt(day) <= getDaysOfMonth(date, month)) {
            System.out.println(year.reverse().append("-").append(month).append("-").append(day));
        }
    }

    private static int getDaysOfMonth(int year, String month) {
        int daysOfMonth;

        switch (month) {
            case "01":
                return daysOfMonth = 31;
            case "02":
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    return daysOfMonth = 29;
                } else {
                    return daysOfMonth = 28;
                }
            case "03":
                return daysOfMonth = 31;
            case "04":
                return daysOfMonth = 30;
            case "05":
                return daysOfMonth = 31;
            case "06":
                return daysOfMonth = 30;
            case "07":
                return daysOfMonth = 31;
            case "08":
                return daysOfMonth = 31;
            case "09":
                return daysOfMonth = 30;
            case "10":
                return daysOfMonth = 31;
            case "11":
                return daysOfMonth = 30;
            case "12":
                return daysOfMonth = 31;
            default:
                return 0;

        }
    }
}
