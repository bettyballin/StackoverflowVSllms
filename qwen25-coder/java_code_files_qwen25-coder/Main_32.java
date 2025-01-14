import java.sql.*;
import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Assuming you have a ResultSet 'rs' from your original query
        ResultSet rs = getResultSet(); // Placeholder for your actual ResultSet
        LocalDateTime startTimestamp = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endTimestamp = LocalDateTime.of(2023, 1, 2, 0, 0);

        List<LocalDateTime> timeSeries = generateTimeSeries(startTimestamp, endTimestamp);
        Map<LocalDateTime, Integer> valueMap = new HashMap<>();

        try {
            while (rs.next()) {
                LocalDateTime timestamp = rs.getTimestamp("received").toLocalDateTime();
                int value = rs.getInt("value");
                valueMap.put(timestamp, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            // Handle the case where rs is null (since getResultSet() returns null)
            System.out.println("ResultSet is null. Skipping data retrieval.");
        }

        // Interpolate missing values
        for (LocalDateTime ts : timeSeries) {
            if (!valueMap.containsKey(ts)) {
                // Set to previous known value or handle as needed
                LocalDateTime prevTs = findPreviousTimestamp(valueMap.keySet(), ts);
                if (prevTs != null) {
                    int interpolatedValue = valueMap.get(prevTs).intValue();
                    valueMap.put(ts, interpolatedValue);
                } else {
                    // Handle the case when there is no previous timestamp
                    valueMap.put(ts, 0); // Default value or as needed
                }
            }
        }

        // Now you have a map `valueMap` with all your data points filled in.
    }

    private static List<LocalDateTime> generateTimeSeries(LocalDateTime start, LocalDateTime end) {
        List<LocalDateTime> timeSeries = new ArrayList<>();
        LocalDateTime current = start;
        while (!current.isAfter(end)) {
            timeSeries.add(current);
            current = current.plusHours(1); // Adjust the interval as needed
        }
        return timeSeries;
    }

    private static LocalDateTime findPreviousTimestamp(Set<LocalDateTime> timestamps, LocalDateTime ts) {
        LocalDateTime prevTs = null;
        for (LocalDateTime t : timestamps) {
            if (t.isBefore(ts)) {
                if (prevTs == null || t.isAfter(prevTs)) {
                    prevTs = t;
                }
            }
        }
        return prevTs;
    }

    // Placeholder method for obtaining a ResultSet
    private static ResultSet getResultSet() {
        // Implement this method to return your actual ResultSet
        return null;
    }
}