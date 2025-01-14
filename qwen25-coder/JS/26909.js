function toProperCase(name) {\n    return name.toLowerCase().replace(/(\b|-)([a-z])/gi, (match) => match.toUpperCase());\n}\n\n// Test cases\nconsole.log(toProperCase("John SMITH")); // John Smith\nconsole.log(toProperCase("Mary O'SMITH")); // Mary O'Smith\nconsole.log(toProperCase("E.t MCHYPHEN-SMITH")); // E.T McHyphen-Smith\nconsole.log(toProperCase("John Middlename SMITH")); // John Middlename Smith