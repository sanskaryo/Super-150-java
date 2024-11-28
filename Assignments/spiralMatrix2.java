import java.io.Serial;
import java.util.Scanner;

public class spiralMatrix2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        printSpiral(matrix, row, col);
        sc.close(); 
    }

    static void printSpiral(int[][] matrix, int r, int c) {
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        int totalElements = 0;


        while (totalElements <r*c){
            for(int i= top; i<=bottom && totalElements<r*c;i++){
                System.out.print(matrix[i][left]+" ");
                totalElements++;
            }
            left++;

            for(int j = left; j<=right && totalElements<r*c;j++){
                System.out.print(matrix[bottom][j]+" ");
                totalElements++;
            }
            bottom--;
            for(int i = bottom; i>=top && totalElements<r*c;i--){
                System.out.print(matrix[i][right]+" ");
                totalElements++;
            }
            right--;

            for(int j = right; j>=left && totalElements<r*c;j--){
                System.out.print(matrix[top][j]+" ");
                totalElements++;
            }
            top++;
        }

    //     while (totalElements < r * c) {
    //         for (int j = left; j <= right && totalElements < r * c; j++) {
    //             System.out.print(matrix[top][j] + " ");
    //             totalElements++;
    //         }
    //         top++;

    //         for (int i = top; i <= bottom && totalElements < r * c; i++) {
    //             System.out.print(matrix[i][right] + " ");
    //             totalElements++;
    //         }
    //         right--;

    //         for (int j = right; j >= left && totalElements < r * c; j--) {
    //             System.out.print(matrix[bottom][j] + " ");
    //             totalElements++;
    //         }
    //         bottom--;

    //         for (int i = bottom; i >= top && totalElements < r * c; i--) {
    //             System.out.print(matrix[i][left] + " ");
    //             totalElements++;
    //         }
    //         left++;
    //     }
    // }
}
}
// Required libraries
#include <SPI.h>
#include <Wire.h>

// Define pin assignments
const int flowMeterPin = A0;  // Analog pin for flow meter
const int fuelLevelPin = A1;   // Analog pin for fuel level sensor
const int voltageSensorPin = A2; // Analog pin for voltage sensor
const int currentSensorPin = A3; // Analog pin for current sensor

void setup() {
    Serial.begin(9600); // Starts serial communication at 9600 bps
}

void loop() {
    // Read the values from the sensors
    int flowMeterValue = analogRead(flowMeterPin);
    int fuelLevelValue = analogRead(fuelLevelPin);
    int voltageValue = analogRead(voltageSensorPin);
    int currentValue = analogRead(currentSensorPin);
    
    // Convert raw values to meaningful metrics (these formulas depend on your specific sensors)
    float flowRate = flowMeterValue * (5.0 / 1023.0); // Example conversion
    float fuelLevel = fuelLevelValue * (100.0 / 1023.0); // Percentage
    float voltage = voltageValue * (5.0 / 1023.0) * 5; // Assuming it reads 0-5V
    float current = currentValue * (5.0 / 1023.0); // Example conversion

    // Print to serial for monitoring
    Serial.print("Flow Rate: "); Serial.print(flowRate); Serial.println(" L/h");
    Serial.print("Fuel Level: "); Serial.print(fuelLevel); Serial.println("%");
    Serial.print("Voltage: "); Serial.print(voltage); Serial.println(" V");
    Serial.print("Current: "); Serial.print(current); Serial.println(" A");
    
    // Delay before the next reading
    delay(1000);
}


// Required libraries
#include <SPI.h>
#include <Wire.h>

// Define pin assignments
const int flowMeterPin = A0;  // Analog pin for flow meter
const int fuelLevelPin = A1;   // Analog pin for fuel level sensor
const int voltageSensorPin = A2; // Analog pin for voltage sensor
const int currentSensorPin = A3; // Analog pin for current sensor

void setup() {
    Serial.begin(9600); // Starts serial communication at 9600 bps
}

void loop() {
    // Read the values from the sensors
    int flowMeterValue = analogRead(flowMeterPin);
    int fuelLevelValue = analogRead(fuelLevelPin);
    int voltageValue = analogRead(voltageSensorPin);
    int currentValue = analogRead(currentSensorPin);
    
    // Convert raw values to meaningful metrics (these formulas depend on your specific sensors)
    float flowRate = flowMeterValue * (5.0 / 1023.0); // Example conversion
    float fuelLevel = fuelLevelValue * (100.0 / 1023.0); // Percentage
    float voltage = voltageValue * (5.0 / 1023.0) * 5; // Assuming it reads 0-5V
    float current = currentValue * (5.0 / 1023.0); // Example conversion

    // Print to serial for monitoring
    Serial.print("Flow Rate: "); Serial.print(flowRate); Serial.println(" L/h");
    Serial.print("Fuel Level: "); Serial.print(fuelLevel); Serial.println("%");
    Serial.print("Voltage: "); Serial.print(voltage); Serial.println(" V");
    Serial.print("Current: "); Serial.print(current); Serial.println(" A");
    
    // Delay before the next reading
    delay(1000);
}
