function stripHTMLTags(str) {\n  var tempDiv = document.createElement("div");\n  tempDiv.innerHTML = str;\n  return tempDiv.textContent || tempDiv.innerText || "";\n}\n\n// Example usage\nvar htmlString = "<p>This is a <strong>test</strong> string with <a href='#'>HTML</a> tags.</p>";\nvar strippedString = stripHTMLTags(htmlString);\nconsole.log(strippedString); // Output: "This is a test string with HTML tags."