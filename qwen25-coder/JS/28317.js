const text = "The rain in Spain stays mainly in the plain.";\nconst regex = /ain/g;\nconst matches = [];\n\nlet match;\nwhile ((match = regex.exec(text)) !== null) {\n    matches.push(match[0]);\n}\n\nconsole.log(matches); // Output: ["ain", "ain", "ain"]