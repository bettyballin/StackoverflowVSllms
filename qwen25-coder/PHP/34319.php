$time = $diff['days'] * 24; // Initialize $time with days converted to hours\n$time += $diff['hours'];     // Add hours to $time\n$time += ($diff['minutes'] / 60); // Convert minutes to hours and add to $time\n$time += (($diff['seconds'] / 60)/60); // Convert seconds to hours and add to $time