CultureInfo culture = CultureInfo.CreateSpecificCulture("ar-SA");\nDateTimeFormatInfo dtfi = culture.DateTimeFormat;\ndtfi.Calendar = new GregorianCalendar();\nThread.CurrentThread.CurrentCulture = culture;