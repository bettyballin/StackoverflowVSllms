-- First day of the current week (assuming Monday is the first day of the week)\nSELECT DATE_TRUNC('week', CURRENT_DATE) AS FirstDayOfCurrentWeek\n\n-- First day of the last week (assuming Monday is the first day of the week)\nSELECT DATE_TRUNC('week', CURRENT_DATE) - INTERVAL '7 days' AS FirstDayOfLastWeek