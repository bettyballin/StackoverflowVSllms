// Example ios-driver test\nconst iosDriver = require('ios-driver');\n\nconst driver = new iosDriver();\ndriver.findElementByXPath('//UIAApplication[1]/UIAWindow[1]/UIAButton[1]').click();