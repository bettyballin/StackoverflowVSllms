from pkg_resources import iter_entry_points\n  for entry_point in iter_entry_points('myapp.plugins'):\n      plugin = entry_point.load()\n      plugin.execute()