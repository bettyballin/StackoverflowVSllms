function scrollToHash(hash) {\n    // Set the hash to a temporary value\n    window.location.hash = '#temporary';\n\n    // Use setTimeout to set the hash to the target value after a short delay\n    setTimeout(function() {\n        window.location.hash = hash;\n    }, 10); // The timeout can be adjusted as needed\n}\n\n// Usage:\nscrollToHash('#page_top');