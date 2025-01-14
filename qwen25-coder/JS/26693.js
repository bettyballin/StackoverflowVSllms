const express = require('express');\n   const app = express();\n   const bodyParser = require('body-parser');\n\n   // Middleware to parse JSON bodies\n   app.use(bodyParser.json());\n\n   // Mock function to simulate fetching data from a database\n   function fetchDataFromDatabase(selectedValue) {\n       // Example data, replace with actual database query logic\n       if (selectedValue === 'category1') {\n           return ['Option 1', 'Option 2'];\n       } else if (selectedValue === 'category2') {\n           return ['Option A', 'Option B', 'Option C'];\n       }\n       return [];\n   }\n\n   app.post('/getOptions', (req, res) => {\n       const selectedValue = req.body.selectedValue;\n       const options = fetchDataFromDatabase(selectedValue);\n       res.json(options);\n   });\n\n   app.listen(3000, () => console.log('Server running on port 3000'));