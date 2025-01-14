from datetime import timedelta\n\nclass Event:\n    def __init__(self, duration):\n        # Assuming 'duration' is a timedelta object\n        self.duration = duration\n\n    def get_duration_in_hours_minutes(self):\n        total_seconds = int(self.duration.total_seconds())\n        hours = total_seconds // 3600\n        minutes = (total_seconds % 3600) // 60\n        return f"{hours}:{minutes:02}"\n\n# Example usage:\nevent = Event(timedelta(hours=3, minutes=45))\nprint(event.get_duration_in_hours_minutes())  # Output: "3:45"