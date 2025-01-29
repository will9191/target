package org.example.challenges;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Number3 {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode revenueJson = objectMapper.readTree(new File("src/main/resources/revenue.json"));

            List<Double> values = new ArrayList<>();
            double lowest = Double.MAX_VALUE;
            double highest = Double.MIN_VALUE;
            double sum = 0;

            for (JsonNode day : revenueJson) {
                double value = day.get("value").asDouble();

                if (value > 0) {
                    values.add(value);
                    sum += value;
                    if (value < lowest) lowest = value;
                    if (value > highest) highest = value;
                }
            }

            double average = sum / values.size();
            int daysAboveAverage = 0;

            for (double value: values){
                if (value > average){
                    daysAboveAverage++;
                }
            }

            System.out.println("Lower revenue: " + lowest);
            System.out.println("Higher revenue: " + highest);
            System.out.println("Average: " + average);
            System.out.println("Days above monthly average: " + daysAboveAverage);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
