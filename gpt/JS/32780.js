const express = require('express');\n   const app = express();\n\n   app.get('/api', (req, res) => {\n       res.json({ message: 'Hello, World!' });\n   });\n\n   const PORT = process.env.PORT || 3000;\n   app.listen(PORT, () => {\n       console.log(`Server running on port ${PORT}`);\n   });