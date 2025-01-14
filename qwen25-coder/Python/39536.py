import spacy\n\n# Load the pre-trained model\nnlp = spacy.load("en_core_web_sm")\n\ndef extract_locations(text):\n    doc = nlp(text)\n    locations = [ent.text for ent in doc.ents if ent.label_ == "GPE"]\n    return locations\n\n# Example usage\nblog_text = "The blog is about New York and its famous landmarks like the Statue of Liberty."\nprint(extract_locations(blog_text))