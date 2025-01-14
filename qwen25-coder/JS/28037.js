// main.js\n\nfunction loadScript(url, callback) {\n    const script = document.createElement('script');\n    script.src = url;\n    script.onload = callback;\n    document.head.appendChild(script);\n}\n\n// Load another JS file and execute a callback when it's loaded\nloadScript('utils.js', function() {\n    console.log("Utils.js has been loaded!");\n    // You can now use anything defined in utils.js here.\n});