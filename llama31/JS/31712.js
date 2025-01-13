const express = require('express');\nconst app = express();\n\napp.get('/users', (req, res) => {\n  // Return a list of users\n  res.json([{ id: 1, name: 'John Doe' }, { id: 2, name: 'Jane Doe' }]);\n});\n\napp.listen(3000, () => {\n  console.log('Server listening on port 3000');\n});