$st_dt = new DateTime(verifyParam('start_date'));\n$end_dt = new DateTime(verifyParam('end_date'));\n\n// Check if the end date is earlier than the start date\nif ($end_dt < $start_dt) {\n    echo "The end date is before the start date.";\n} elseif ($end_dt > $start_dt) {\n    echo "The end date is after the start date.";\n} else {\n    echo "Both dates are the same.";\n}