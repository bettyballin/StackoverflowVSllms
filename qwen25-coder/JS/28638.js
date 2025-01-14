// Get all external resources\nconst resources = document.querySelectorAll('img, link[rel="stylesheet"], script');\n\nlet loadedCount = 0;\nconst totalCount = resources.length;\n\nfunction updateProgress() {\n    loadedCount++;\n    const remainingCount = totalCount - loadedCount;\n    console.log(`${loadedCount} objects loaded, ${remainingCount} ones remain! Please wait.`);\n}\n\nresources.forEach(resource => {\n    if (resource.complete) { // For resources that may have already completed loading by the time we attach this\n        updateProgress();\n    } else {\n        resource.addEventListener('load', updateProgress);\n        resource.addEventListener('error', () => { // Handle errors to ensure progress continues even on failures\n            console.log(`Failed to load ${resource.src || resource.href}`);\n            loadedCount++;\n            updateProgress();\n        });\n    }\n});