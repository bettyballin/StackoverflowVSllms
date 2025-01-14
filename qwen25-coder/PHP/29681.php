// Application\Controller\CalendarController.php\npublic function indexAction()\n{\n    $startDate = time();\n    $endDate = strtotime('+3 years');\n    $events = [\n        // Example events array, in real-world you might fetch this from a database\n        strtotime('2024-01-15') => 'Event 1',\n        strtotime('2024-05-20') => 'Event 2',\n        // Add more events here...\n    ];\n\n    $calDates = [];\n    for ($date = $startDate; $date < $endDate; $date += 86400) { // +86400 seconds == +1 day\n        $calDates[date('Y-m-d', $date)] = isset($events[$date]) ? $events[$date] : null;\n    }\n\n    return new ViewModel([\n        'dates' => $calDates,\n    ]);\n}