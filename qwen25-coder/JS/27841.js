const puppeteer = require('puppeteer');\nconst rimraf = require('rimraf');\nconst path = require('path');\nconst fs = require('fs');\n\n(async () => {\n    const browser = await puppeteer.launch();\n    const page = await browser.newPage();\n\n    // Visit the page you want to take a screenshot of\n    await page.goto('http://example.com', { waitUntil: 'networkidle2' });\n\n    // Take a screenshot and save it as example.png\n    await page.screenshot({ path: 'example.png' });\n\n    // Read the golden image (baseline) from disk - this should be created manually after first run if not exists\n    const dir = path.join(__dirname, '/goldens/example_golden.png');\n    if (!fs.existsSync(dir)) {\n        fs.writeFileSync('goldens/example_golden.png', await page.screenshot(), { encoding: 'base64' });\n        console.log("Golden image saved for future regression tests.");\n    }\n\n    // Compare the screenshot with the golden one\n    const baselineImage = fs.readFileSync(dir);\n    const newImage = fs.readFileSync(path.join(__dirname, '/example.png'));\n\n    if (baselineImage.equals(newImage)) {\n        console.log('No visual changes detected');\n    } else {\n        console.error('Visual changes detected in example.png');\n        // Optionally save this as a diff image\n        await page.screenshot({ path: 'diff_example.png', fullPage: true });\n    }\n\n    browser.close();\n})();