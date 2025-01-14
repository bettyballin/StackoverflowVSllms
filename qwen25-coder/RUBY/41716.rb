require 'date'\n\n# Example datetime strings\nstart_time_str = "Mon Jul 20 18:25:17 -0400 2009"\nend_time_str = "Mon Jul 20 18:49:43 -0400 2009"\n\n# Parse the datetime strings\nstart_time = DateTime.parse(start_time_str)\nend_time = DateTime.parse(end_time_str)\n\n# Calculate the duration in seconds\nduration_seconds = (end_time - start_time) * 24 * 60 * 60\n\nputs "Duration: #{duration_seconds} seconds"