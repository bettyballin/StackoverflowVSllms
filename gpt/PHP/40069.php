<?php\n// Ensure error reporting is enabled for debugging\nini_set('display_errors', 1);\nerror_reporting(E_ALL);\n\n// Collect user credentials securely\n$username = $_POST['username'];\n$password = $_POST['password'];\n$icalData = "BEGIN:VCALENDAR\nVERSION:2.0\nPRODID:-//hacksw/handcal//NONSGML v1.0//EN\nBEGIN:VEVENT\nUID:uid1@example.com\nDTSTAMP:20231010T100000Z\nDTSTART:20231010T100000Z\nSUMMARY:Event Example\nEND:VEVENT\nEND:VCALENDAR";\n\n// Sanitize the filename for security\n$fileName = 'calendar.ics';\n\n// WebDAV URL on ServerB\n$webdavUrl = 'https://your-serverb.com/path/to/webdav/' . $fileName;\n\n// Initialize cURL session\n$ch = curl_init();\n\n// Set cURL options\ncurl_setopt($ch, CURLOPT_URL, $webdavUrl);\ncurl_setopt($ch, CURLOPT_USERPWD, "$username:$password");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");\ncurl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: text/calendar'));\ncurl_setopt($ch, CURLOPT_POSTFIELDS, $icalData);\n\n// Execute cURL session and capture response\n$response = curl_exec($ch);\n\n// Check for errors\nif (curl_errno($ch)) {\n    echo 'Error:' . curl_error($ch);\n} else {\n    // Check HTTP status code for success\n    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);\n    if ($httpCode == 201 || $httpCode == 204) {\n        echo "File uploaded successfully";\n    } else {\n        echo "Failed to upload file. HTTP Status Code: $httpCode";\n    }\n}\n\n// Close cURL session\ncurl_close($ch);\n?>