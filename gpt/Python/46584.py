from datetime import datetime\nfrom myapp.models import Weather\n\nspecific_day = datetime(2009, 1, 31)\nWeather.objects.filter(timestamp__date=specific_day.date())