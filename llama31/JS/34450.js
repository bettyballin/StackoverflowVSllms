const puppeteer = require('puppeteer');\n\n(async () => {\n  const browser = await puppeteer.launch();\n  const page = await browser.newPage();\n  await page.goto('https://example.com');\n  const html = await page.content();\n  console.log(html);\n  await browser.close();\n})();