<?php\n$year = date('Y');\n$month = date('m');\n$events = [\n    '2023-12-25' => 'Christmas',\n    '2023-12-31' => 'New Year\'s Eve'\n];\necho $this->calendar($year, $month, $events);\n?>