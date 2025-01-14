def calculate_downtime(uptime_percentage, time_period_seconds):\n    return (1 - uptime_percentage) * time_period_seconds\n\n# Define parameters\nuptime_required = 0.9998\nseconds_in_a_year = 365 * 24 * 3600\n\n# Calculate allowable downtime\nallowable_downtime_seconds = calculate_downtime(uptime_required, seconds_in_a_year)\nprint(f"Allowable Downtime for 99.98% Uptime in a Year: {allowable_downtime_seconds} seconds")