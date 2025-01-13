// Set the culture to Arabic (Saudi Arabia)\nvar cultureInfo = new CultureInfo("ar-SA");\n\n// Set the calendar to GregorianCalendar\ncultureInfo.DateTimeFormat.Calendar = new GregorianCalendar();\n\n// Apply the culture to the current thread\nThread.CurrentThread.CurrentCulture = cultureInfo;\nThread.CurrentThread.CurrentUICulture = cultureInfo;