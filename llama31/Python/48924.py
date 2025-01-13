import datetime\nimport pytz\n\ndef get_midnight_utc(timezone_str):\n    tz = pytz.timezone(timezone_str)\n    midnight = tz.localize(datetime.datetime.now(tz).date())\n    return midnight.astimezone(pytz.UTC)\n\n# Example usage:\ntimezone_str = "Australia/Melbourne"\nmidnight_utc = get_midnight_utc(timezone_str)\nprint(midnight_utc)