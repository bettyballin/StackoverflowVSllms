//select the event end date of event ID\n$sql = "SELECT enddate FROM mm_eventlist_dates WHERE id = $id";\n$result = mysql_query($sql);\n\nif ($result && mysql_num_rows($result) > 0) {\n    // Fetch the row from the result set\n    $row = mysql_fetch_assoc($result);\n    $enddate = $row['enddate'];\n\n    // Use the fetched end date to find the event that starts the next day\n    $sql = "SELECT id FROM mm_eventlist_dates WHERE startdate = DATE_ADD('$enddate', INTERVAL 1 DAY)";\n    $nextResult = mysql_query($sql);\n\n    if ($nextResult && mysql_num_rows($nextResult) > 0) {\n        $nextRow = mysql_fetch_assoc($nextResult);\n        echo "Next Event ID: " . $nextRow['id'];\n    } else {\n        echo "No event found that starts the next day.";\n    }\n} else {\n    echo "Event with ID $id not found.";\n}