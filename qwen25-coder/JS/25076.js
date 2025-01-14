function isElementExplicitlyClosed(element) {\n    // Get the outer HTML as a string\n    const outerHtml = element.outerHTML;\n    \n    // Check if the outerHTML contains a closing tag\n    return outerHtml.includes(`</${element.tagName.toLowerCase()}>`);\n}\n\nconst anchorElement = document.querySelector('a');\nconsole.log(isElementExplicitlyClosed(anchorElement));  // Returns true or false