<?php\n$last1Min = time() - 60;\n$last5Mins = time() - 300;\n$last1Hr = time() - 3600;\n$last1Dy = time() - 86400;\n$last1Wk = time() - 604800;\n$last1Mnth = time() - 2592000;\n\n$sql = "\nSELECT \n    page,\n    SUM(lastOnline > $last1Min) as last1Min,\n    SUM(lastOnline > $last5Mins) as last5Mins,\n    SUM(lastOnline > $last1Hr) as last1Hr,\n    SUM(lastOnline > $last1Dy) as last1Dy,\n    SUM(lastOnline > $last1Wk) as last1Wk,\n    SUM(lastOnline > $last1Mnth) as last1Mnth\nFROM usersonline\nGROUP BY page";\n\n$result = mysql_query($sql);\nwhile ($row = mysql_fetch_assoc($result)) {\n    echo "Page: " . $row['page'] . "<br />";\n    echo "Users online in the last minute: " . $row['last1Min'] . "<br />";\n    echo "Users online in the last 5 minutes: " . $row['last5Mins'] . "<br />";\n    echo "Users online in the last hour: " . $row['last1Hr'] . "<br />";\n    echo "Users online in the last day: " . $row['last1Dy'] . "<br />";\n    echo "Users online in the last week: " . $row['last1Wk'] . "<br />";\n    echo "Users online in the last month: " . $row['last1Mnth'] . "<br /><br />";\n}\n?>