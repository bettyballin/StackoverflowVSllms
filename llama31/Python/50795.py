import chardet\n\nwith open('example.txt', 'rb') as file:\n    rawdata = file.read()\n    result = chardet.detect(rawdata)\n    charenc = result['encoding']\n\nprint(charenc)