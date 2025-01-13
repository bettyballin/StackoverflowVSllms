using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class Event\n{\n    public DateTime StartTime { get; set; }\n    // other properties...\n}\n\npublic class Program\n{\n    private static List<Event> GetEventsInRange(List<Event> events, DateTime startDate, DateTime endDate)\n    {\n        // Ensure the list is sorted by StartDate if it's not already\n        events.Sort((e1, e2) => e1.StartTime.CompareTo(e2.StartTime));\n\n        // Perform binary search to find the first event that starts after or when startDate\n        int startIdx = events.BinarySearch(new Event { StartTime = startDate }, Comparer<Event>.Create((e1, e2) => e1.StartTime.CompareTo(e2.StartTime)));\n        \n        if (startIdx < 0)\n        {\n            // If not found, BinarySearch returns the complement of the index of the next higher\n            startIdx = ~startIdx;\n        }\n\n        // Perform binary search to find the first event that starts after endDate\n        int endIdx = events.BinarySearch(new Event { StartTime = endDate.AddTicks(1) }, Comparer<Event>.Create((e1, e2) => e1.StartTime.CompareTo(e2.StartTime)));\n\n        if (endIdx < 0)\n        {\n            // If not found, BinarySearch returns the complement of the index of the next higher\n            endIdx = ~endIdx;\n        }\n\n        // Return events in range [startIdx, endIdx)\n        return events.GetRange(startIdx, endIdx - startIdx);\n    }\n\n    public static void Main()\n    {\n        var events = new List<Event>\n        {\n            new Event { StartTime = new DateTime(2023, 1, 1) },\n            new Event { StartTime = new DateTime(2023, 1, 7) },\n            new Event { StartTime = new DateTime(2023, 1, 25) },\n            // add more events as needed\n        };\n\n        var startDate = new DateTime(2023, 1, 6);\n        var endDate = new DateTime(2023, 1, 26);\n        \n        var filteredEvents = GetEventsInRange(events, startDate, endDate);\n\n        foreach (var ev in filteredEvents)\n        {\n            Console.WriteLine($"Event at: {ev.StartTime}");\n        }\n    }\n}