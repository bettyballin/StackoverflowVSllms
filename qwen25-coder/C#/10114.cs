using System;\nusing System.Globalization;\n\n// Assuming ddlStartTime is your DropDownList control\nstring selectedTime = ddlStartTime.SelectedItem.Text; // e.g., "8:00AM"\n\n// Parse the time part using a custom format\nDateTime timeValue;\nif (DateTime.TryParseExact(selectedTime, \n                            new[] { "h:mmtt", "h:mm tt" }, \n                            CultureInfo.InvariantCulture, \n                            DateTimeStyles.None, \n                            out timeValue))\n{\n    // Combine with today's date\n    DateTime combinedDateTime = new DateTime(DateTime.Today.Year, DateTime.Today.Month, DateTime.Today.Day, \n                                             timeValue.Hour, timeValue.Minute, 0);\n\n    // Format as desired (you can adjust the format string)\n    string formattedDateTime = combinedDateTime.ToString("MM/dd/yyyy HH:mm:ss.fff");\n\n    Console.WriteLine(formattedDateTime);\n}\nelse\n{\n    throw new Exception("Invalid time format.");\n}