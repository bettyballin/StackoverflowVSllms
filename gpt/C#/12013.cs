using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Linq;\n\nclass Program\n{\n    static void Main()\n    {\n        // Load carrier prefix codes into a dictionary\n        var carrierPrefixes = LoadCarrierPrefixes("carrier_prefixes.csv");\n\n        // Load dialed numbers and minutes from a CSV file\n        var dialedNumbers = LoadDialedNumbers("dialed_numbers.csv");\n\n        // Initialize subtotal dictionary\n        var carrierTraffic = new Dictionary<string, int>();\n\n        // Process each dialed number\n        foreach (var dialedNumber in dialedNumbers)\n        {\n            string phoneNumber = dialedNumber.Item1;\n            int minutes = dialedNumber.Item2;\n\n            // Find the matching carrier prefix\n            foreach (var prefix in carrierPrefixes)\n            {\n                if (phoneNumber.StartsWith(prefix.Key))\n                {\n                    if (!carrierTraffic.ContainsKey(prefix.Value))\n                    {\n                        carrierTraffic[prefix.Value] = 0;\n                    }\n                    carrierTraffic[prefix.Value] += minutes;\n                    break; // Assuming one number matches only one carrier prefix\n                }\n            }\n        }\n\n        // Output results\n        foreach (var carrier in carrierTraffic)\n        {\n            Console.WriteLine($"Carrier: {carrier.Key}, Total Minutes: {carrier.Value}");\n        }\n    }\n\n    static Dictionary<string, string> LoadCarrierPrefixes(string filePath)\n    {\n        var prefixes = new Dictionary<string, string>();\n        var lines = File.ReadAllLines(filePath);\n\n        foreach (var line in lines)\n        {\n            var parts = line.Split(',');\n            if (parts.Length == 2)\n            {\n                prefixes.Add(parts[0], parts[1]); // Assuming format: prefix,carrier_name\n            }\n        }\n\n        return prefixes;\n    }\n\n    static List<Tuple<string, int>> LoadDialedNumbers(string filePath)\n    {\n        var numbers = new List<Tuple<string, int>>();\n        var lines = File.ReadAllLines(filePath);\n\n        foreach (var line in lines)\n        {\n            var parts = line.Split(',');\n            if (parts.Length == 2 && int.TryParse(parts[1], out int minutes))\n            {\n                numbers.Add(new Tuple<string, int>(parts[0], minutes)); // Assuming format: number,minutes\n            }\n        }\n\n        return numbers;\n    }\n}