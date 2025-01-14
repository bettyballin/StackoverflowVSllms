require 'caracal'\n\n# Define document properties\nproperties = {\n  company:    'Your Company, Inc.',\n  keywords:   ['sample', 'document'],\n  subject:    'Sample Document',\n  title:      'A Simple Document'\n}\n\n# Create and populate the document\nCaracal::Document.save('example.docx', properties) do |doc|\n\n  # Add a header with centered text that spans all columns.\n  doc.header(columns: 1) {\n    row(height: 20) { cell { paragraph align: :center, text: 'Sample Header' } }\n  }\n\n  # Add some paragraphs\n  doc.paragraph 'This is a sample document.'\n  doc.paragraph 'Here is another line of text.'\n\n  # Add a styled paragraph with bold and underline.\n  doc.paragraph bold: true, underline: true, size: 18,\n              color: '#FF0000', text: 'Important Styled Text'\n\nend