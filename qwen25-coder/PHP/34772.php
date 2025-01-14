function date_diff($old_date, $new_date) {\n    $dt1 = new DateTime($old_date);\n    $dt2 = new DateTime($new_date);\n\n    // Set both dates to UTC to ignore DST\n    $dt1->setTimezone(new DateTimeZone('UTC'));\n    $dt2->setTimezone(new DateTimeZone('UTC'));\n\n    // Subtract the two dates and get the interval in days\n    $interval = $dt1->diff($dt2);\n    return $interval->days;\n}\n\n// Example usage:\necho date_diff('3/15/09', '3/18/09'); // 3\necho date_diff('11/15/08', '3/18/09'); // 124