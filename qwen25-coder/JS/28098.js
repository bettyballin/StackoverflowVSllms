var huff = new Huffman16(freqs);\nvar encoded = huff.Encode(raw);\nvar raw = huff.Decode(encoded);