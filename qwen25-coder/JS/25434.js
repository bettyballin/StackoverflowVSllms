const { Builder, By, until } = require('selenium-webdriver');\n// To use Internet Explorer driver, ensure it is installed and the server started: https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/#internet-explorer\n\n(async function example() {\n    let driver;\n    try {\n        driver = await new Builder().forBrowser('internet explorer').build();\n        await driver.get('http://example.com');\n        const title = await driver.getTitle();\n        console.log(`Page Title: ${title}`);\n        \n        // Measure page load time\n        const startTime = Date.now();\n        await driver.wait(until.presenceOf(By.tagName('body')), 10000);\n        const timeTaken = Date.now() - startTime;\n        console.log(`Time taken to load the page: ${timeTaken}ms`);\n    } catch (e) {\n        console.error(e);\n    } finally {\n        await driver.quit();\n    }\n})();