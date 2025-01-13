using System;\nusing System.Globalization;\n\nclass Program\n{\n    static void Main()\n    {\n        string dateString = "April,1,2009";\n        DateTime date = DateTime.ParseExact(dateString, "MMMM,d/yyyy", CultureInfo.InvariantCulture);\n        \n        // Format the date to show month as a number\n        string formattedDate = date.ToString("M/d/yyyy");\n        \n        Console.WriteLine(formattedDate); // Output: 4/1/2009\n    }\n}