const express = require('express');\nconst bodyParser = require('body-parser');\nconst app = express();\n\napp.use(bodyParser.json());\n\napp.post('/log-click', (req, res) => {\n    console.log(req.body); // Log or save the data as needed\n    res.status(200).send();\n});\n\napp.listen(3000, () => {\n    console.log('Server running on http://localhost:3000');\n});