package org.example.challenges;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Number4 {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode revenueJson = objectMapper.readTree(new File("src/main/resources/statesRevenue.json"));

            double totalRevenue = 0;

            for (JsonNode state : revenueJson) {
                double value = state.get("value").asDouble();
                totalRevenue += value;
            }

            for (JsonNode state : revenueJson) {
                double percentage = (state.get("value").asDouble() / totalRevenue) * 100;
                System.out.printf("Percentage of %s: %.2f%%%n", state.get("name"), percentage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
