if (isset($_POST['date'])) {\n    $date = $_POST['date']; // Get the date from the form in mm/dd/yyyy format\n    $timestamp = strtotime($date); // Convert to Unix timestamp\n    \n    if ($timestamp === false) {\n        echo 'Invalid date format.';\n    } else {\n        echo 'Unix timestamp: ' . $timestamp;\n    }\n} else {\n    echo 'No date provided.';\n}