SELECT MIN(time_diff) AS smallest_time_diff\nFROM (\n  SELECT `time` - LAG(`time`) OVER (ORDER BY `time`) AS time_diff\n  FROM `temperatures`\n) AS diffs;