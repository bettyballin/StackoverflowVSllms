// Example response string with JSON embedded in comments\nconst response = "/*{ \"name\": \"John\", \"age\": 30 } */";\n\n// Remove comment tags before parsing\nconst jsonPart = response.replace('/*', '').replace('*/', '');\nconst data = JSON.parse(jsonPart);\n\nconsole.log(data);