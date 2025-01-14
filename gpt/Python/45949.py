from datetime import datetime, timezone\n\n# Example UTC time string\nutc_time_str = '2023-10-15T12:34:56Z'\n\n# Parse the UTC time string to a datetime object\nutc_time = datetime.strptime(utc_time_str, '%Y-%m-%dT%H:%M:%SZ')\n\n# Convert the datetime object to a Unix timestamp\nunix_timestamp = int(utc_time.replace(tzinfo=timezone.utc).timestamp())\n\nprint(unix_timestamp)