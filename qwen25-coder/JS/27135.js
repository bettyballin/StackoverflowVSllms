function estimateDPI() {\n    // Get screen width in pixels\n    const screenWidth = window.screen.width;\n    // Get the approximate width of the screen in inches (e.g., 15.6 for a laptop)\n    // This is an estimation and can vary by device type/model\n    const estimatedScreenWidthInches = 24; // Estimation, change as needed\n\n    // Calculate DPI based on pixels per inch\n    const dpiX = screenWidth / estimatedScreenWidthInches;\n    \n    console.log(`Estimated DPI: ${dpiX.toFixed(2)}`);\n    return dpiX;\n}\n\nestimateDPI();