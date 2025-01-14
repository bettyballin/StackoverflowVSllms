def fread():\n    record = False\n    d = None\n    for line in open('somefile.txt'):\n        if line.startswith('Record'):\n            if record:\n                yield d  # Yield the previous record before starting a new one\n            record = True\n            d = SomeObject()\n\n        # do some processing with line\n        d.process(line)\n\n        if not line.strip() and record:\n            yield d\n            record = False\n\n    # Check if there's an unyielded record at the end of the file\n    if record:\n        yield d\n\nfor record in fread():\n    print(record)