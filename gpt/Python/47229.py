def truncate_text(text, word_limit=100):\n    words = text.split()\n    if len(words) > word_limit:\n        return ' '.join(words[:word_limit]) + '...'\n    return text\n\ntext = "Your long text goes here..."\nprint(truncate_text(text))