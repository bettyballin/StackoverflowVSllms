def hours(self):\n    retval = ""\n    if self.totalTime:\n        hoursfloat = self.totalTime.seconds / 3600\n        retval = round(hoursfloat)\n    return retval\n\ndef minutes(self):\n    retval = ""\n    if self.totalTime:\n        minutesfloat = self.totalTime.seconds / 60\n        hoursAsMinutes = self.hours() * 60\n        retval = round(minutesfloat - hoursAsMinutes)\n    return retval