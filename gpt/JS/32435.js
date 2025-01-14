// Function to update the CSS rule\nfunction updateCSSRule(selector, property, value) {\n  var sheets = document.styleSheets;\n  for (var i = 0; i < sheets.length; i++) {\n    var sheet = sheets[i];\n    var rules = sheet.cssRules || sheet.rules;\n    for (var j = 0; j < rules.length; j++) {\n      if (rules[j].selectorText === selector) {\n        rules[j].style[property] = value;\n        return;\n      }\n    }\n  }\n}\n\n// Example usage to change the width to "30%"\nupdateCSSRule('#tId', 'width', '30%');