import re\n\ndef clean_text(text):\n    # Remove punctuation\n    text = re.sub(r'[^\w\s]', '', text)\n    # Convert to lowercase\n    text = text.lower()\n    # Remove extra spaces\n    text = re.sub(r'\s+', ' ', text).strip()\n    return text\n\ninput_text = "Hello, World! This is a sample text."\ncleaned_text = clean_text(input_text)\nprint(cleaned_text)