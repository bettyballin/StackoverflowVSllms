function getSpecifiedStyle(element, propertyName) {\n  const styleSheets = document.styleSheets;\n  for (let i = 0; i < styleSheets.length; i++) {\n    const styleSheet = styleSheets[i];\n    for (let j = 0; j < styleSheet.cssRules.length; j++) {\n      const rule = styleSheet.cssRules[j];\n      if (element.matches(rule.selectorText)) {\n        if (rule.style.getPropertyValue(propertyName)) {\n          return rule.style.getPropertyValue(propertyName);\n        }\n      }\n    }\n  }\n  return null; // or return a default value\n}