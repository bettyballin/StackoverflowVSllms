const express = require('express');\nconst cors = require('cors');\nconst app = express();\n\napp.use(cors());\n\napp.get('/user/flair', function(req, res) {\n    // Typically you would fetch this data from a database or another service\n    const userData = {\n        success: true,\n        user: {\n            name: 'John Doe',\n            reputation: 1500\n            // Add other fields as necessary\n        }\n    };\n    \n    res.json(userData);\n});\n\napp.listen(3000, function() {\n    console.log('Server is running on http://localhost:3000');\n});