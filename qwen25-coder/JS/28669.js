const puppeteer = require('puppeteer');\n\n(async () => {\n    const browser = await puppeteer.launch();\n    const page = await browser.newPage();\n\n    // Example HTML content\n    const htmlContent = `\n        <html>\n            <head><title>Sample</title></head>\n            <body>\n                <h1>Hello, world!</h1>\n                <p>This is a sample text.</p>\n            </body>\n        </html>\n    `;\n\n    await page.setContent(htmlContent);\n    await page.screenshot({ path: 'output.png' });\n\n    await browser.close();\n})();