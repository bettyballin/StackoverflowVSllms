$pattern = '/^([0-9]{1,2}|\*)\s+([0-9]{1,2}|\*)\s+([0-9]{1,2}|\*)\s+([0-9]{1,2}|\*)\s+([0-9]{1,2}|\*)$/';\n\nif (preg_match($pattern, $userInput)) {\n    // The cron expression is valid\n} else {\n    // The cron expression is invalid\n}