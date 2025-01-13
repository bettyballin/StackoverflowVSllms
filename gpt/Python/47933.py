import spacy\n\n    nlp = spacy.load("en_core_web_sm")\n    doc = nlp(html_content)\n    for ent in doc.ents:\n        if ent.label_ == "GPE":  # GPE stands for Geopolitical Entity\n            print("Address found:", ent.text)