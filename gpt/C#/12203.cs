using System;\nusing System.Collections.Generic;\n\nclass Program\n{\n    static void Main()\n    {\n        // Initialize the multidimensional list (list of lists)\n        List<List<string>> playlist = new List<List<string>>();\n        \n        // Example data for a track\n        List<string> track1 = new List<string> { "2349", "The Prime Time of Your Life", "Daft Punk", "Human After All", "3", "2" };\n        List<string> track2 = new List<string> { "2350", "Around the World", "Daft Punk", "Homework", "5", "1" };\n        \n        // Add tracks to the playlist\n        playlist.Add(track1);\n        playlist.Add(track2);\n        \n        // Accessing elements\n        Console.WriteLine("Track ID of song 1: " + playlist[0][0]);\n        Console.WriteLine("Name of song 2: " + playlist[1][1]);\n\n        // Printing entire playlist\n        for (int i = 0; i < playlist.Count; i++)\n        {\n            Console.WriteLine($"Track {i + 1}:");\n            for (int j = 0; j < playlist[i].Count; j++)\n            {\n                Console.WriteLine(playlist[i][j]);\n            }\n            Console.WriteLine();\n        }\n    }\n}