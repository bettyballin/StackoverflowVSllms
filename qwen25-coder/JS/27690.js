const express = require('express');\nconst app = express();\nconst path = require('path');\n\napp.get('/myfile.pdf', function(req, res) {\n    var filePath = path.join(__dirname, 'path_to_your_file/myfile.pdf');\n    res.setHeader('Content-Disposition', 'attachment; filename="myfile.pdf"');\n    res.sendFile(filePath);\n});\n\napp.listen(3000, () => {\n    console.log('Server running on port 3000');\n});