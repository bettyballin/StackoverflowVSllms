// Select all elements and filter those containing the exact string\nvar foundElements = $('*').filter(function() {\n    return $(this).text().trim() === "I am a simple string";\n});\n\n// Log or manipulate the found elements\nfoundElements.each(function() {\n    console.log($(this));\n});