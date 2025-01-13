from datetime import datetime, timedelta\n\ndef average_delta(dates):\n    # Sort the dates in ascending order\n    dates.sort()\n\n    # Calculate the total delta\n    total_delta = timedelta(0)\n    for i in range(1, len(dates)):\n        total_delta += dates[i] - dates[i-1]\n\n    # Calculate the average delta\n    average_delta = total_delta / (len(dates) - 1)\n\n    return average_delta\n\n# Example usage\ndates = [datetime(2008, 10, 1, 12, 15, 0), \n         datetime(2008, 10, 1, 12, 25, 0), \n         datetime(2008, 10, 1, 12, 35, 0)]\n\naverage = average_delta(dates)\nprint(average)