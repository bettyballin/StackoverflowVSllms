require_once 'Date.php'; // Ensure the Date class is included\n\n// Assuming $timezone is already defined and valid\n$now = new Date();\n$tzone = new Date_TimeZone($timezone);\n$now->convertTZ($tzone);\n\n// Get timestamp from the Date object\n$start = $now->getTimestamp();\n\n// Create another Date object for the end of business time\n$eobDate = new Date("2009/07/02 17:00");\n$eobDate->convertTZ($tzone); // Ensure it's in the same timezone\n\n// Get timestamp from the end of business time\n$eob = $eobDate->getTimestamp();\n\n// Calculate the difference in seconds\n$timediff = $eob - $start;\n\necho "Time difference in seconds: " . $timediff;