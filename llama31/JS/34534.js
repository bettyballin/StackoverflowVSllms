const chardet = require('chardet');\n\n// ...\n\napp.post('/path', (req, res) => {\n  const buffer = Buffer.from(req.body, 'binary');\n  const charset = chardet.detect(buffer).encoding;\n\n  // ...\n});