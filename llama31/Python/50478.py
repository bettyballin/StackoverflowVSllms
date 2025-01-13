import unicodedata\n\n# Define the essential Unicode ranges for Japanese support\njapanese_ranges = [\n    (0x3300, 0x33FF),  # Compatibility\n    (0xFE30, 0xFE4F),  # Compatibility Forms\n    (0xF900, 0xFAFF),  # Compatibility Ideographs\n    (0x3000, 0x303F),  # Symbols and Punctuation\n    (0x4E00, 0x9FBB),  # Unified Ideographs\n    (0x3400, 0x4DB5),  # Unified Ideographs Ext. A\n    (0x20000, 0x2A6D6),  # Unified Ideographs Ext. B\n    (0x3040, 0x309F),  # Hiragana\n    (0x30A0, 0x30FF),  # Katakana\n    (0x31F0, 0x31FF),  # Katakana Phonetic\n    (0xFF00, 0xFFEF),  # Halfwidth and Fullwidth Forms\n    (0x1F600, 0x1F64F),  # Japanese Emoticons and Symbols\n]\n\n# Create a set of Japanese characters\njapanese_chars = set()\nfor start, end in japanese_ranges:\n    japanese_chars.update(chr(i) for i in range(start, end + 1))\n\n# Use this set to filter or validate Japanese text\ndef is_japanese(text):\n    return all(unicodedata.category(c) == 'Lo' or c in japanese_chars for c in text)