using System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Simulated database values\n        string country = "France";\n        string hotel = "Hotel Movenpick";\n\n        // Convert to lowercase and replace spaces with hyphens\n        string formattedCountry = FormatString(country);\n        string formattedHotel = FormatString(hotel);\n\n        // Construct the URL\n        string url = $"http://www.travel.com/{formattedCountry}/{formattedHotel}";\n\n        Console.WriteLine(url);\n    }\n\n    static string FormatString(string input)\n    {\n        return input.ToLower().Replace(" ", "-");\n    }\n}