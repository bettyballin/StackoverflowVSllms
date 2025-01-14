import spacy\n\n# Load a pre-trained model with NER capabilities\nnlp = spacy.load("en_core_web_sm")\n\n# Example HTML content (usually you would parse the HTML to extract text)\nhtml_content = "<p>Please contact us at 123 Main St, Springfield, IL 62704.</p>"\n\n# Extract only the text part from HTML content\nimport re\ntext_content = re.sub('<[^<]+?>', '', html_content)\n\n# Process with spaCy NER\ndoc = nlp(text_content)\n\n# Print recognized entities\nfor ent in doc.ents:\n    if ent.label_ == "GPE" or ent.label_ == "CARDINAL":  # GPE: Geopolitical Entity, CARDINAL for numbers in addresses\n        print(ent.text, ent.label_)