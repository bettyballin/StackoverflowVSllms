const express = require('express');\nconst app = express();\nconst port = 3000;\n\nconst items = ["Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape"];\n\napp.get('/autocomplete', (req, res) => {\n    const term = req.query.term.toLowerCase();\n    const filteredItems = items.filter(item => item.toLowerCase().includes(term));\n    res.json(filteredItems);\n});\n\napp.get('/filter', (req, res) => {\n    const selection = req.query.selection;\n    // Perform your dataset filtering logic here\n    const filteredResults = items.filter(item => item === selection); // Example logic\n    res.json(filteredResults);\n});\n\napp.listen(port, () => {\n    console.log(`Server running at http://localhost:${port}`);\n});