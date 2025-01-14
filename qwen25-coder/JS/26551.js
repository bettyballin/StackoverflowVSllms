const fs = require('fs');\nconst path = require('path');\nconst { JSDOM } = require('jsdom');\nconst express = require('express');\nconst request = require('request-promise-native');\n\nconst app = express();\n// Set up your server routes here as in Kohana\n\nasync function renderPage(url, outputPath) {\n    const html = await request(`http://localhost:3000${url}`);\n    const dom = new JSDOM(html);\n    \n    // Execute JavaScript if necessary (be cautious about CORS and other restrictions)\n    // dom.window.eval(dom.window.document.body.innerText);\n\n    fs.writeFileSync(outputPath, dom.serialize());\n    console.log(`Rendered ${outputPath}`);\n}\n\nasync function main() {\n    app.use(express.static(path.join(__dirname, 'public')));\n    const server = app.listen(3000, async () => {\n        // Render the static pages you need\n        await renderPage('/index', path.join('exported-site', 'index.html'));\n        await renderPage('/about', path.join('exported-site', 'about.html'));\n        \n        // Close the server after rendering is done\n        server.close();\n    });\n\n}\n\nmain().catch(console.error);