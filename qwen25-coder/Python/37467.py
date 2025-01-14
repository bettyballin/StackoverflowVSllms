from datetime import datetime\nimport pytz\n\n# Example Unix timestamp\nunix_timestamp = 1701825480\n\n# Convert to UTC time\nutc_time = datetime.utcfromtimestamp(unix_timestamp).replace(tzinfo=pytz.utc)\n\n# Format as ISO 8601 with timezone\niso_format_time = utc_time.isoformat()\nprint(iso_format_time)  # Output: 2023-12-05T14:38:00+00:00