from odf.opendocument import OpenDocumentText\nfrom odf.style import ParagraphProperties, Style\nfrom odf.text import P\n\n# Create a text document\ndoc = OpenDocumentText()\n\n# Create and add style for paragraphs\np_style = Style(name="P1", family="paragraph")\np_properties = ParagraphProperties(margintop="0.2cm", marginbottom="0.2cm")\np_style.addElement(p_properties)\ndoc.automaticstyles.addElement(p_style)\n\n# Add a formatted paragraph with a comment\ntext = P(text="This is an example text for the document.", stylename=p_style.name)\ncomment = text.addComment("This is an invisible comment", creator="AuthorName")\n\n# Add paragraph to the document\ndoc.text.addElement(text)\n\n# Save the document\ndoc.save("example_document.odt")