$sql = "SELECT FROM_UNIXTIME(timecode, '%Y-%m-%d %H:00:00') AS hour, COUNT(*) AS count\n        FROM timecodeTable\n        GROUP BY hour";