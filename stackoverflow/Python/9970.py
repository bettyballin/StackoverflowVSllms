def tail(f, n, offset=None):\n    """Reads a n lines from f with an offset of offset lines.  The return\n    value is a tuple in the form ``(lines, has_more)`` where `has_more` is\n    an indicator that is `True` if there are more lines in the file.\n    """\n    avg_line_length = 74\n    to_read = n + (offset or 0)\n\n    while 1:\n        try:\n            f.seek(-(avg_line_length * to_read), 2)\n        except IOError:\n            # woops.  apparently file is smaller than what we want\n            # to step back, go to the beginning instead\n            f.seek(0)\n        pos = f.tell()\n        lines = f.read().splitlines()\n        if len(lines) >= to_read or pos == 0:\n            return lines[-to_read:offset and -offset or None], \\n                   len(lines) > to_read or pos > 0\n        avg_line_length *= 1.3