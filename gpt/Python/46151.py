from datetime import datetime, timedelta\n\ndef get_last_weekday_date(target_weekday):\n    today = datetime.today()\n    today_weekday = today.weekday()  # Monday is 0 and Sunday is 6\n    delta_days = today_weekday - target_weekday\n    if delta_days < 0:\n        delta_days += 7\n    last_weekday_date = today - timedelta(days=delta_days)\n    return last_weekday_date\n\n# Example usage:\n# Convert 1-7 weekday to 0-6 (Python's weekday)\n# For example, Friday is 5 (since Monday is 0)\ntarget_weekday = 4  # 0 = Monday, 1 = Tuesday, ..., 6 = Sunday\nlast_friday = get_last_weekday_date(target_weekday)\nprint("Last Friday's date was:", last_friday.strftime('%Y-%m-%d'))