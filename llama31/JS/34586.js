const puppeteer = require('puppeteer');\n\n(async () => {\n  const browser = await puppeteer.launch();\n  const page = await browser.newPage();\n  await page.setContent(yourHtmlContent);\n\n  const element = await page.$('#myElement');\n  const boundingBox = await element.boundingBox();\n  const pageHeight = await page.evaluate(() => globalThis.innerHeight);\n\n  if (boundingBox.y + boundingBox.height > pageHeight) {\n    // Element has gone off the bottom of the page\n    // You can move it to the next page or adjust its position as needed\n  }\n\n  await page.pdf({ path: 'output.pdf' });\n  await browser.close();\n})();