$driver->wait($timeout)->until(\n    WebDriverExpectedCondition::presenceOfElementLocated(WebDriverBy::id('inputId'))\n);\n\n$inputElement = $driver->findElement(WebDriverBy::id('inputId'));\n$inputElement->sendKeys('Your text here');