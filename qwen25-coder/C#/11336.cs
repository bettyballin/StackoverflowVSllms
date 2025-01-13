// Initialize the main list that will hold lists of track information.\nList<List<string>> matrix = new List<List<string>>();\n\n// Example data: Track 1\nList<string> track1 = new List<string>\n{\n    "2349", // Track ID\n    "The Prime Time of Your Life", // Name\n    "Daft Punk", // Artist\n    "Human After All", // Album\n    "3", // Play Count\n    "2"  // Skip Count\n};\n\n// Example data: Track 2\nList<string> track2 = new List<string>\n{\n    "4567", // Track ID\n    "Instant Crush",\n    "Daft Punk",\n    "Tron Legacy Soundtrack",\n    "5",\n    "1"\n};\n\n// Add tracks to the matrix.\nmatrix.Add(track1);\nmatrix.Add(track2);\n\n// Accessing elements\nstring trackIDOfFirstTrack = matrix[0][0]; // Outputs: 2349\nstring nameOfSecondTrack = matrix[1][1]; // Outputs: Instant Crush