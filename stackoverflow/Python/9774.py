import struct\n\ndef getData():\n    data = []\n    for i in range( 0, 1024 ):\n        data.append( 0.25 * math.sin( math.radians( i ) ) )\n    return struct.pack('f'*len(data), *data)