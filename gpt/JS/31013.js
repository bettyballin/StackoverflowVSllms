const puppeteer = require('puppeteer');\n\n(async () => {\n  const browser = await puppeteer.launch();\n  const page = await browser.newPage();\n\n  // Replace this URL with the URL of your offline version of the CBT\n  await page.goto('file:///path/to/your/offline/version.html', { waitUntil: 'networkidle0' });\n\n  await page.pdf({\n    path: 'output.pdf', // Path to save the PDF\n    format: 'A4', // Paper format, you can customize it\n    printBackground: true // Print background graphics\n  });\n\n  await browser.close();\n})();