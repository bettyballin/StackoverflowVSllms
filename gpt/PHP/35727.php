<?php\nfunction timeToSeconds($time) {\n    $dateTime = new DateTime($time);\n    return $dateTime->getTimestamp();\n}\n\n$t1 = "3:15:00";\n$t2 = "1:00:00";\n$t3 = "2:00:00";\n$t4 = "9:00:00";\n\n$seconds1 = timeToSeconds($t1);\n$seconds2 = timeToSeconds($t2);\n$seconds3 = timeToSeconds($t3);\n$seconds4 = timeToSeconds($t4);\n\necho $seconds1 . "\n";\necho $seconds2 . "\n";\necho $seconds3 . "\n";\necho $seconds4 . "\n";\n?>