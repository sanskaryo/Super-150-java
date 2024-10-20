import java.util.Scanner;  

public class clockconversion {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        
        // Read the number of test cases  
        int t = scanner.nextInt();  
        scanner.nextLine(); // Consume the newline character  
        
        for (int i = 0; i < t; i++) {  
            String time24 = scanner.nextLine();  
            String time12 = convertTo12HourFormat(time24);  
            System.out.println(time12);  
        }  
        
        scanner.close();  
    }  

    private static String convertTo12HourFormat(String time24) {  
        // Split the input into hours and minutes  
        String[] parts = time24.split(":");  
        int hour = Integer.parseInt(parts[0]);  
        String minute = parts[1];  

        String period;  
        if (hour >= 12) {  
            period = "PM";  
            if (hour > 12) {  
                hour -= 12; // Convert to 12-hour format  

            }  
        } else {  
            period = "AM";  
            if (hour == 0) {  
                hour = 12; // Midnight case  
            }  
        }  

        // Format the hour to ensure it has two digits  
        String formattedHour = String.format("%02d", hour);  


        // Return the formatted time in 12-hour format  
        return formattedHour + ":" + minute + " " + period;  
    }  
}