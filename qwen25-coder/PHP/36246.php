$monthPart = ($date[0] == 0) ? '' : '\d'; // or '[12]' if month can only start with 1 or 2\n$dayPart   = ($date[2] == 0) ? '' : '\d'; // similar adjustment as needed\n\n$regex = '/^' . $monthPart . '?\/?[' . $date[2] . ']?' . $dayPart . '?\/?' . $date[3] . '$/';