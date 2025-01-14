const puppeteer = require('puppeteer');\n\n(async () => {\n  // Launch the browser\n  const browser = await puppeteer.launch();\n  const page = await browser.newPage();\n\n  // Open a webpage\n  await page.goto('http://www.example.com');\n\n  // Find an element and interact with it\n  await page.type('input[name="q"]', 'Hello, World!');\n  await page.keyboard.press('Enter');\n\n  // Wait for some time to see the results\n  await page.waitForTimeout(2000);\n\n  // Close the browser\n  await browser.close();\n})();