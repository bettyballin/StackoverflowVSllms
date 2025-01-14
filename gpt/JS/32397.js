const puppeteer = require('puppeteer');\n\n   (async () => {\n     const browser = await puppeteer.launch();\n     const page = await browser.newPage();\n     await page.goto('http://example.com', {waitUntil: 'networkidle2'});\n     await page.evaluate(() => {\n       // Execute JavaScript on the page if needed\n     });\n     await page.screenshot({path: 'example.png'});\n     await browser.close();\n   })();