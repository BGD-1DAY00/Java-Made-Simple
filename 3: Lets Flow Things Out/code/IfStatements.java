public class IfStatements {
    public static void main(String[] args) {
        // Basic if statement
        int number = 10;
        if (number > 0) {
            System.out.println("Number is positive");
        }

        System.out.println("\n--- Next Example ---\n");

        // If-else statement
        int age = 18;
        if (age >= 18) {
            System.out.println("You are an adult");
        } else {
            System.out.println("You are a minor");
        }

        System.out.println("\n--- Next Example ---\n");

        // If-else-if ladder
        int score = 75;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }

        System.out.println("\n--- Next Example ---\n");

        // Nested if statements
        boolean hasLicense = true;
        int drivingAge = 16;
        if (age >= drivingAge) {
            if (hasLicense) {
                System.out.println("You can drive");
            } else {
                System.out.println("You need a license to drive");
            }
        } else {
            System.out.println("You are too young to drive");
        }

        System.out.println("\n--- Next Example ---\n");

        // Using logical operators in if statements
        boolean isWeekend = true;
        boolean isHoliday = false;
        if (isWeekend || isHoliday) {
            System.out.println("No work today!");
        } else {
            System.out.println("It's a working day");
        }

        System.out.println("\n--- Next Example ---\n");

        // Ternary operator (conditional operator)
        int x = 5;
        int y = 10;
        int max = (x > y) ? x : y;
        System.out.println("The maximum value is: " + max);

        System.out.println("\n--- Next Example ---\n");

        // Switch statement (alternative to multiple if-else)
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
        }
    }
}
