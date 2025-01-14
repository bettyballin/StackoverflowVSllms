import calendar\n\nclass CustomHTMLCalendar(calendar.HTMLCalendar):\n    def __init__(self, firstweekday=0, events=None):\n        super(CustomHTMLCalendar, self).__init__(firstweekday)\n        # Dictionary where keys are tuples of (year, month, day) and values are the data to insert\n        self.events = events if events else {}\n\n    def formatday(self, day, weekday):\n        if day == 0:\n            return '<td class="noday">&nbsp;</td>'  # day outside month's range\n        cssclass = "filled" if (self.firstweekday + weekday) % 7 == self.firstweekday else "unfilled"\n        if self.events.get((self.year, self.month, day)):\n            data = f"<br/>{self.events[(self.year, self.month, day)]}"\n        else:\n            data = ''\n        return '<td class="%s">%d%s</td>' % (cssclass, day, data)\n\n    def formatmonth(self, year, month):\n        self.year, self.month = year, month\n        return super().formatmonth(year, month)\n\n\n# Example usage\nevents = {\n    (2009, 7, 14): "Special Date",\n    (2009, 7, 28): "My Data"\n}\n\nmyCal = CustomHTMLCalendar(calendar.SUNDAY, events)\nprint(myCal.formatmonth(2009, 7))