text = "Your text here with a  line separator"\ncleaned_text = text.replace('\u2028', '')\nprint(cleaned_text)