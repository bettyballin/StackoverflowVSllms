function currentDateTime() {\n  list($micro, $Unixtime) = explode(" ", microtime());\n  $sec = $micro + date("s", $Unixtime);\n  // Correct usage of sprintf to format a string\n  $formatted_sec = sprintf('%f', $sec); // Assuming you want the seconds as a float with decimal places\n  return date("Y-m-d H:i:s", $Unixtime) . $formatted_sec;\n}\n\n$formatted_date_time = currentDateTime();\necho $formatted_date_time; // You need to echo or use the returned value here