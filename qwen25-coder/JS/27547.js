// Function to set the meta refresh time\nfunction setMetaRefresh(seconds, url) {\n    // Remove any existing meta refresh tags\n    var metaTags = document.getElementsByTagName('meta');\n    for (var i = 0; i < metaTags.length; i++) {\n        if (metaTags[i].getAttribute("http-equiv") === "refresh") {\n            document.head.removeChild(metaTags[i]);\n        }\n    }\n\n    // Create a new meta refresh tag\n    var metaRefresh = document.createElement('meta');\n    metaRefresh.setAttribute("http-equiv", "refresh");\n    metaRefresh.setAttribute("content", seconds + ";url=" + url);\n    \n    // Add the new meta tag to the head of the document\n    document.head.appendChild(metaRefresh);\n}\n\n// Example usage: Reset meta refresh to 300 seconds and point to logout page\nsetMetaRefresh(300, '/logout');