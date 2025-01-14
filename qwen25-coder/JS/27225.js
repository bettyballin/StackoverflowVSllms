require(["dojo/router", "dojo/domReady!"], function(router) {\n    // Define routes\n    router.register("/site/contacts", function() {\n        console.log("Show contacts list");\n        // Load contacts logic here\n    });\n    \n    router.register("/site/contacts/active", function() {\n        console.log("Show active contacts");\n        // Load active contacts logic here\n    });\n\n    // Start the routing system\n    router.startup();\n});