$sql = "SELECT FROM_UNIXTIME(timecode, '%Y-%m') AS month, COUNT(*) AS count\n        FROM timecodeTable\n        GROUP BY month";