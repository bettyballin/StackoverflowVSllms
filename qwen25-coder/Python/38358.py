from datetime import datetime, timedelta\n\ndef get_week_dates(year, week_number):\n    # Find the first day of the year.\n    current_date = datetime.strptime(f'{year}-01-01', '%Y-%m-%d')\n    \n    # Adjust to the first Monday of the year.\n    first_monday = current_date - timedelta(days=current_date.weekday())\n    \n    # Calculate the start date of the given week number.\n    start_of_week = first_monday + timedelta(weeks=(week_number-1))\n    \n    # Generate list of dates for the week (Monday to Sunday).\n    week_dates = [(start_of_week + timedelta(days=i)).strftime('%Y-%m-%d') for i in range(7)]\n    \n    return week_dates\n\n# Example usage:\nyear = 2008\nweek_number = 40\ndates = get_week_dates(year, week_number)\nfor date in dates:\n    print(date)