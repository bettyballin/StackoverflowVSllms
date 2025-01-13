using System;\nusing System.Threading;\n\nclass Program {\n    static void DisplayValues(int altitude, string direction, int windSpeed, string windDirection) {\n        Console.Write($"\rAltitude: {altitude,5}ft      Direction: {direction}\n");\n        Console.Write($"Wind:     {windSpeed,3}km, {windDirection}\n");\n        Console.Out.Flush();\n    }\n\n    static void Main() {\n        int altitude = 9876;\n        string direction = "NE";\n        int windSpeed = 5;\n        string windDirection = "NE";\n\n        while (true) {\n            DisplayValues(altitude, direction, windSpeed, windDirection);\n\n            // Simulate changing values\n            altitude += 10;\n            if (altitude > 10000) altitude = 9876;\n\n            Thread.Sleep(1000); // Wait for 1 second before updating again\n        }\n    }\n}