// assume 'userTimezoneOffset' is the user's timezone offset in minutes\n// and 'eventTimeUtc' is the event time in seconds from midnight UTC\nint userTime = eventTimeUtc + (userTimezoneOffset * 60);