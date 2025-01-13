import csv\nimport codecs\n\ndef unicode_csv_reader(filename, dialect=csv.excel, **kwargs):\n    with codecs.open(filename, 'r', encoding='utf-8') as csvfile:\n        reader = csv.reader(csvfile, dialect=dialect, **kwargs)\n        for row in reader:\n            yield [cell for cell in row]\n\nfilename = 'output.csv'\nreader = unicode_csv_reader(filename)\n\ntry:\n    products = []\n    for field1, field2, field3 in reader:\n        #...