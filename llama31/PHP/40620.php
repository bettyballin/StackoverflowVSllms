$originalTime = strtotime('2022-01-01 12:00:00'); // Replace with your original time\n$newTime = strtotime('-5 hours', $originalTime);\n\necho date('Y-m-d H:i:s', $newTime);