<?php\n// Set the target date for the event (Year, Month, Day)\n$targetDate = new DateTime('2023-12-25'); // Example: Christmas 2023\n\n// Get the current date and time using server time\n$currentDate = new DateTime();\n\n// Calculate the difference between the current date and the target date\n$interval = $currentDate->diff($targetDate);\n\n// Display the number of days until the event\necho $interval->days . ' days to go for the great event';\n?>