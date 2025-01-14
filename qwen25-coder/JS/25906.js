function preventFrameBust() {\n    // Save the current location\n    const lastValidLocation = document.location.href;\n\n    function checkIfFrameBusted() {\n        if (lastValidLocation !== document.location.href) {\n            // If frame busting is detected, redirect back to our controlled page in the iframe\n            window.top.location.href = lastValidLocation;\n        }\n    }\n\n    // Add event listeners for popstate and hashchange as these are commonly used by frame-busting scripts.\n    setInterval(checkIfFrameBusted, 100);\n    addEventListener('popstate', checkIfFrameBusted);\n    addEventListener('hashchange', checkIfFrameBusted);\n}\n\n// Ensure the iframe content loads first\nwindow.onload = function() {\n    const iframe = document.getElementById('myIframe');\n    if (iframe && iframe.contentWindow) {\n        // Wait for content to load before applying frame bust prevention\n        iframe.onload = preventFrameBust;\n    }\n};