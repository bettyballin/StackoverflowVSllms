def calculate_avg_speed(distance, time_str):\n    # Parse the time string\n    hours, minutes, seconds_ms = time_str.split(":")\n    seconds, milliseconds = seconds_ms.split(".")\n    total_seconds = (int(hours) * 3600) + (int(minutes) * 60) + int(seconds) + (int(milliseconds) / 1000)\n\n    # Calculate the average speed\n    avg_speed = distance / (total_seconds / 3600)\n\n    return avg_speed\n\n# Example usage:\ndistance = 50  # in km\ntime_str = "00:02:04.05"\navg_speed = calculate_avg_speed(distance, time_str)\nprint("Average speed:", avg_speed, "km/h")