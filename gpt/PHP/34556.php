<?php\n$mil = 1227643821310;\n$seconds = $mil / 1000;\n\n// Set the default timezone to UTC or the specific timezone you need\ndate_default_timezone_set('UTC');\n\necho date("d-m-Y", $seconds);\n?>