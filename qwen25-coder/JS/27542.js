// Sample markup with links\nlet dirtyHTML = '<p>description like <a href="myexample.com"></a></p>';\n\n// Sanitize the HTML\nlet cleanHTML = DOMPurify.sanitize(dirtyHTML, {\n  RETURN_TRUSTED_TYPE: true,\n});\n\n// Function to remove specific links (e.g., those linking to "myexample.com")\nfunction removeSpecificLinks(html) {\n  // Create a temporary element to manipulate the DOM\n  const doc = new DOMParser().parseFromString(html, 'text/html');\n  \n  // Find all anchor tags\n  const anchors = doc.querySelectorAll('a');\n  \n  anchors.forEach(anchor => {\n    if (anchor.href.includes('myexample.com')) {\n      // Replace the link content with an empty string or any other desired behavior\n      anchor.outerHTML = '';\n    }\n  });\n\n  // Return the cleaned and modified HTML as a string\n  return doc.body.innerHTML;\n}\n\n// Apply the function to remove specific links\nlet finalCleanHTML = removeSpecificLinks(cleanHTML);\n\nconsole.log(finalCleanHTML); // Output: <p>description like </p>