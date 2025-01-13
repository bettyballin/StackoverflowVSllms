SELECT \n    i.serial_number, i.counter, i.selected_color\nFROM\n   (\n   SELECT      serial_number, MAX(counter) AS maxc\n   FROM            incoming_data \n   GROUP BY    serial number\n   ) max\n   JOIN\n   incoming_data i ON max.serial_number = i.serial_number AND max.maxc = i.counter