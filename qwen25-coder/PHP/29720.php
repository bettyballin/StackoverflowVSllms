<?php\n$date = new DateTime("now", new DateTimeZone('America/New_York'));\necho "Current time in New York: " . $date->format('Y-m-d H:i:s') . "\n";\n\n$date = new DateTime("now", new DateTimeZone('America/Indianapolis'));\necho "Current time in Indianapolis: " . $date->format('Y-m-d H:i:s') . "\n";\n?>