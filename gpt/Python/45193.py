# Open the input file in binary mode and read its contents\nwith open('input.csv', 'rb') as fread:\n    data = fread.read()\n\n# Decode the data from UTF-16 to a string\ndecoded_data = data.decode('utf-16')\n\n# Optionally, encode the string to ASCII, ignoring characters that cannot be represented in ASCII\nascii_data = decoded_data.encode('ascii', 'ignore')\n\n# Write the ASCII-encoded data to a new file\nwith open('input-ascii.csv', 'wb') as fwrite:\n    fwrite.write(ascii_data)