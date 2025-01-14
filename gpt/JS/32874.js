var name = "Matt";\nvar htmlContent = `\n  <html>\n    <head>\n      <title>Print Document</title>\n      <style>\n        /* Add your styles here if needed */\n        body { font-family: Arial, sans-serif; }\n        .content { width: 300px; height: 20px; background-color: #000; color: #fff; text-align: center; }\n      </style>\n    </head>\n    <body>\n      <div class="content">My name is ${name}</div>\n    </body>\n  </html>\n`;\n\n// Open a new window\nvar newWindow = window.open('', '', 'width=600,height=400');\n\n// Write the HTML content to the new window\nnewWindow.document.write(htmlContent);\n\n// Close the document to finish writing and render the content\nnewWindow.document.close();\n\n// Wait for the content to load and then print\nnewWindow.onload = function() {\n  newWindow.print();\n  newWindow.close(); // Optional: Close the print window after printing\n};