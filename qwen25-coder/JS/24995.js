app.use((req, res, next) => {\n    res.setHeader('Cache-Control', 'no-store, no-cache, must-revalidate');\n   	res.setHeader('Pragma', 'no-cache'); // HTTP 1.0.\n   	res.setHeader('Expires', '0'); // Proxies.\n   	next();\n});