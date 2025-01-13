import re\n\ndef match_12_hour_time(time_str):\n    pattern = r"^(0?[1-9]|1[0-2]):([0-5][0-9])$"\n    if re.match(pattern, time_str):\n        return True\n    else:\n        return False\n\n# Test cases\nprint(match_12_hour_time("12:30"))  # Should return True\nprint(match_12_hour_time("14:74"))  # Should return False