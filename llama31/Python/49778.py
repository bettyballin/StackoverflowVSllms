from django.db.models import Q\n\ndef find_free_slot(duration, start_date_range):\n    # Calculate the end date range\n    end_date_range = start_date_range + duration\n\n    # Filter out periods that overlap with the desired free slot\n    overlapping_periods = Period.objects.filter(\n        Q(start_date__lt=end_date_range) & Q(end_date__gt=start_date_range)\n    )\n\n    # If there are no overlapping periods, return the start date range as the free slot\n    if not overlapping_periods.exists():\n        return start_date_range\n\n    # Otherwise, return None indicating no free slot available\n    return None