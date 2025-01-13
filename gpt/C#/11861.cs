using System;\nusing System.Globalization;\n\npublic class DateParser\n{\n    public DateTime ParseDate(string inputDate)\n    {\n        // Define the expected date format\n        string format = "dd-MM-yyyy";\n        \n        // Parse the input date string using the specified format\n        DateTime parsedDate = DateTime.ParseExact(inputDate, format, CultureInfo.InvariantCulture);\n        \n        return parsedDate;\n    }\n}