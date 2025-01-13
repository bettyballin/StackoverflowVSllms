// Get the total number of elements in the document\nconst totalElements = document.getElementsByTagName('*').length;\n\n// Get the number of loaded elements\nconst loadedElements = performance.getEntriesByType('resource').length;\n\n// Calculate the remaining elements\nconst remainingElements = totalElements - loadedElements;\n\n// Display the result\nconsole.log(`${loadedElements} objects loaded, ${remainingElements} ones remain!`);