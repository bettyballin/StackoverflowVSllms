using System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Example of user input as a string\n        string dateInput = "03-Apr-2009";\n        \n        // Parse the input string to DateTime\n        DateTime userDate;\n        bool isValidDate = DateTime.TryParseExact(dateInput, "dd-MMM-yyyy", null, System.Globalization.DateTimeStyles.None, out userDate);\n        \n        if (!isValidDate)\n        {\n            Console.WriteLine("Invalid date format.");\n            return;\n        }\n\n        // Get the date one year ago from now\n        DateTime oneYearAgo = DateTime.Now.AddYears(-1);\n\n        // Perform the comparison\n        if (userDate > oneYearAgo)\n        {\n            Console.WriteLine("The date entered is within the last year.");\n        }\n        else\n        {\n            Console.WriteLine("The date entered is more than a year ago.");\n        }\n    }\n}