const puppeteer = require('puppeteer');\n\n   (async () => {\n     const browser = await puppeteer.launch();\n     const page = await browser.newPage();\n     await page.goto('https://example.com/some-page');\n     // Extract the HTML of a specific element\n     const content = await page.evaluate(() => document.querySelector('.some-class').innerHTML);\n     console.log(content);\n     await browser.close();\n   })();