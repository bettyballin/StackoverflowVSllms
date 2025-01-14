const fs = require('fs');\nconst {Builder, By} = require('selenium-webdriver');\n\n(async function example() {\n    let driver = await new Builder().forBrowser('chrome').build();\n    try {\n        await driver.get('http://localhost/yourserver/testpage.html');\n        let fileInput = await driver.findElement(By.id('fileInput'));\n        // Provide the path to the file you want to upload\n        await fileInput.sendKeys('/path/to-your/file.txt');\n    } finally {\n        await driver.quit();\n    }\n})();