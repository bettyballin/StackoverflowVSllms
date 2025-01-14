from datetime import datetime, time, timedelta\nimport pytz\n\ndef get_midnight_utc(target_timezone_str):\n    # Current date in UTC without time\n    utc_now = datetime.utcnow().date()\n    \n    # Set the target timezone\n    target_timezone = pytz.timezone(target_timezone_str)\n    \n    # Construct the midnight time in the target timezone\n    local_midnight = target_timezone.localize(datetime.combine(utc_now, time.min))\n    \n    # Convert to UTC\n    utc_midnight = local_midnight.astimezone(pytz.UTC)\n    \n    return utc_midnight.replace(tzinfo=None)\n\n# Example usage\nmidnight_utc = get_midnight_utc("Australia/Melbourne")\nprint(midnight_utc)