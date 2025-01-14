const fs = require('fs');\nconst pdfFiller = require('pdffiller');\n\n// Assuming you can get the username from the environment or some source\nconst username = process.env.USERNAME || 'defaultUser';\n\n// Path to the PDF template and output file\nconst pdfTemplatePath = './template.pdf';\nconst outputPath = './output_with_username.pdf';\n\n// Data to fill into the form fields\nconst data = {\n  "usernameField": username // Ensure this matches the actual name of your field in the PDF\n};\n\npdfFiller.generatePdf(pdfTemplatePath, outputPath, data, function(error) {\n  if (error) {\n    return console.error('Error filling form:', error);\n  }\n  console.log('PDF filled successfully');\n});