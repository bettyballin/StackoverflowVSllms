DateTime utcDateTime = yourDateTimeFromDatabase; // Assume this is the UTC DateTime from DB\nDateTime localDateTime = TimeZone.CurrentTimeZone.ToLocalTime(utcDateTime);