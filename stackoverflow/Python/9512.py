def EntryMatches(e):\n  if use_currency and not (e.currency == currency):\n    return False\n  if use_category and not (e.category == category):\n    return False\n  return True