app.get('/your-api-endpoint', (req, res) => {\n    const format = req.query.format;\n\n    if (format === 'json') {\n        res.json({ key: 'value' });\n    } else if (format === 'xml') {\n        res.set('Content-Type', 'application/xml');\n        res.send('<response><key>value</key></response>');\n    } else {\n        res.send('<div>Your HTML content here</div>');\n    }\n});