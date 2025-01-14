(function() {\n    var openerWindow = window.opener;\n    if (openerWindow) {\n        var width, height;\n\n        if (openerWindow.outerWidth && openerWindow.outerHeight) {\n            // Non-IE browsers\n            width = openerWindow.outerWidth;\n            height = openerWindow.outerHeight;\n        } else {\n            // IE (versions 6 to 8)\n            var body = openerWindow.document.body;\n            var doc = openerWindow.document.documentElement;\n\n            width = Math.max(body.clientWidth, doc.clientWidth);\n            height = Math.max(body.clientHeight, doc.clientHeight);\n\n            // Adjust for the window chrome (approximate)\n            width += 16;  // Assuming 8px padding on each side\n            height += 82; // Assuming 32px title bar + 50px for bottom padding\n        }\n\n        console.log("Width:", width, "Height:", height);\n\n        // Example of resizing the current window based on the opener's size\n        var ratio = 0.8; // Example ratio\n        window.resizeTo(width * ratio, height * ratio);\n    } else {\n        console.error("No opener window found.");\n    }\n})();