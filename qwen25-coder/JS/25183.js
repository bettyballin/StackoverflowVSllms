const fs = require('fs');\n\n// Write "Hello, world!" into 'example.txt'\nfs.writeFile('example.txt', 'Hello, world!', err => {\n  if (err) {\n    console.error(err);\n    return;\n  }\n  // File has been saved successfully.\n  console.log("File saved!");\n});