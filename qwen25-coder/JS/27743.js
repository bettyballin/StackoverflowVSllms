var onloadQueue = [];\n\n// Function to add a new function to the queue\nfunction addLoadEvent(func) {\n    if (typeof window.onload != 'function') {\n        // If no current onload event, just assign the array execution\n        window.onload = function() {\n            for (var i = 0; i < onloadQueue.length; i++) {\n                onloadQueue[i]();\n            }\n        };\n    }\n    onloadQueue.push(func);\n}\n\n// Adding functions to the queue\naddLoadEvent(function(){\n    alert("First event!");\n});\n\naddLoadEvent(function(){\n    alert("Second event!");\n});