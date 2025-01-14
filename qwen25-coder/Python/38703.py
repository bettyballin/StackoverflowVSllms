from datetime import datetime, timedelta\n\ndef calculate_time_diff(start_time, end_time):\n    # Ensure start_time is before end_time\n    if start_time > end_time:\n        raise ValueError("Start time must be before end time")\n\n    # Calculate the remaining seconds of the first day\n    next_day = start_time.replace(hour=0, minute=0, second=0) + timedelta(days=1)\n    first_day_seconds = (next_day - start_time).total_seconds()\n\n    # Calculate the full days between\n    full_days_delta = end_time.date() - next_day.date()\n    full_days_seconds = full_days_delta.total_seconds() * 86400  # convert to seconds\n\n    # Calculate the seconds of the last day\n    last_day_seconds = (end_time - (next_day + timedelta(days=full_days_delta.days))).total_seconds()\n\n    return first_day_seconds, full_days_seconds, last_day_seconds\n\n# Example usage\nstart_time = datetime(2023, 10, 5, 22, 30)  # 10:30 PM on October 5th\nend_time = datetime(2023, 10, 7, 4, 45)    # 4:45 AM on October 7th\n\nfirst_day, full_days, last_day = calculate_time_diff(start_time, end_time)\n\nprint(f"First day seconds: {first_day}")\nprint(f"Full days seconds: {full_days}")\nprint(f"Last day seconds: {last_day}")