function removeAccents(str) {\n    return str.normalize('NFD').replace(/[\u0300-\u036f]/g, '');\n}\n\n// Example usage:\nconst str1 = "Lubeck";\nconst str2 = "Lübeck";\n\nconsole.log(removeAccents(str2).toLowerCase() === str1.toLowerCase()); // true