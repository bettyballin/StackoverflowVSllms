from operator import itemgetter\n\ndef float_or_str(value):\n    try:\n        return float(value)\n    except ValueError:\n        return value\n\ndata.sort(key=lambda x: float_or_str(x[sortby]))