$start_date = new DateTime('2009-06-17');\n$start_date->setTime(0, 0, 0);\n\n$end_date = new DateTime('2009-09-05');\n$end_date->setTime(0, 0, 0);\n\n$date_from_user = new DateTime('2009-08-28');\n$date_from_user->setTime(0, 0, 0);\n\nif ($start_date <= $date_from_user && $date_from_user <= $end_date) {\n    echo "Date is within range";\n} else {\n    echo "Date is outside range";\n}