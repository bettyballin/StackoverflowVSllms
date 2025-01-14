function normalizeHTML(html) {\n    // Use a DOM parser to parse the HTML string into a document object\n    const tempDiv = document.createElement('div');\n    tempDiv.innerHTML = html;\n    \n    // Remove all whitespace characters between tags\n    let normalizedHtml = tempDiv.innerHTML.replace(/\s*(<([^>]+)>)\s*/g, '$1').trim();\n    \n    return normalizedHtml.toLowerCase(); // Also make it case insensitive if needed\n}\n\nfunction replaceInHTML(originalHtml, search, replacement) {\n    const tempDiv = document.createElement('div');\n    tempDiv.innerHTML = originalHtml;\n\n    // Use normalize function to clean up and compare\n    let normalizedSearch = normalizeHTML(search);\n    let normalizedOriginal = normalizeHTML(tempDiv.innerHTML);\n\n    // Perform a case-insensitive replace while preserving the original formatting of the match in the document\n    const regex = new RegExp(normalizedSearch, 'gi');\n    tempDiv.innerHTML = tempDiv.innerHTML.replace(regex, function(match) {\n        return search; // Use the original search text to preserve its HTML formatting\n    });\n\n    return tempDiv.innerHTML;\n}\n\n// Example usage:\nconst productHtml = "other text..<strong>text text <font color=\"#ff6600\">colortext&reg;</font></strong>..other text";\nconst searchString = "<strong><font color=\"&#xff6600;\">colortext&reg;</font></strong>";\nconst replaceString = "<strong><font color=\"#00cc00\">newcolor&reg;</font></strong>";\n\nconst updatedHtml = replaceInHTML(productHtml, searchString, replaceString);\nconsole.log(updatedHtml);