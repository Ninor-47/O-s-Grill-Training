package OsGrillTraining;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Main 
{    
    public static void main(String[] args)
    {
				 Scanner scanner = new Scanner(System.in);

        // Collect user inputs
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Are you a student (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        scanner.nextLine();  // Consume newline left-over

        System.out.print("Enter your street address: ");
        String street = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        // Create JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("age", age);
        jsonObject.put("isStudent", isStudent);
        
        // Create nested address object
        JSONObject address = new JSONObject();
        address.put("street", street);
        address.put("city", city);
        
        jsonObject.put("address", address);

        // Write JSON to a file
        try {
            Files.write(Paths.get("user_data.json"), jsonObject.toString(4).getBytes());
            System.out.println("Data successfully written to user_data.json");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

}
