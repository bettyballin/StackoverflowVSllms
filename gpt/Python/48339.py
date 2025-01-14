from datetime import timedelta\n\ndef format_timedelta(td):\n    total_seconds = int(td.total_seconds())\n    hours, remainder = divmod(total_seconds, 3600)\n    minutes, _ = divmod(remainder, 60)\n    return f"{hours:02}:{minutes:02}"\n\n# Example usage\ntd = timedelta(hours=2, minutes=45, seconds=30)\nformatted_time = format_timedelta(td)\nprint(formatted_time)  # Output: 02:45