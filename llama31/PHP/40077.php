$lastAction = // retrieve the last action timestamp from your database\n$viewerTime = // get the viewer's local time using the above code\nif ($viewerTime->getTimestamp() - $lastAction > 86400) { // 86400 seconds = 24 hours\n    // allow the action\n} else {\n    // block the action\n}