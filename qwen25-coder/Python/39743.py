def getfile(filename):\n    with open(filename, 'r') as f:\n        results = [line.strip() for line in f]\n    return results\n\nblahblah = getfile('/tmp/foo')\n\nfor x in blahblah:\n    print(x)