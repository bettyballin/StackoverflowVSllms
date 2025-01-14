import struct\nimport math\n\ndef getData():\n    data = []\n    for i in range(0, 1024):\n        data.append(0.25 * math.sin(math.radians(i)))\n    \n    # Convert list of floats to byte buffer\n    audio_data = struct.pack('f' * len(data), *data)\n    return audio_data\n\n# Example usage with PortAudio stream\n# stream.write(getData())