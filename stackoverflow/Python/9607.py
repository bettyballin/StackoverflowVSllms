array = [1.0, 1.2, 0.4, ...] # A bunch of numbers\ncounts = {}\nfor a in array:\n  if a in counts:\n    counts[a] += 1\n  else:\n    counts[a] = 1