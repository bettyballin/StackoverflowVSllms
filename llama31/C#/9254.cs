DateTime date = Eval("DatelineDate");\nstring formattedDate = date.ToString("d MMMM yyyy", new CultureInfo("ar-SA") { DateTimeFormat = { Calendar = new GregorianCalendar() } });