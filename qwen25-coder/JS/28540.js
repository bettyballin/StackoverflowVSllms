// ==UserScript==\n// @name         YourScriptName\n// @namespace    http://your.namespace/\n// @version      0.1\n// @description  try to take over the world!\n// @author       You\n// @match        *://*/*\n// @grant        GM_setValue\n// @grant        GM_getValue\n// ==/UserScript==\n\n(function() {\n    'use strict';\n\n    $(document).ready(function() {\n        $("a#linkid").click(function(event) {\n            event.preventDefault(); // Prevent default action if necessary\n            GM_setValue("foo", 123); // Should work now\n            console.log(GM_getValue("foo")); // Check the value in console\n        });\n\n        // Test outside of click event to ensure it works\n        GM_setValue("bar", 123);\n        console.log(GM_getValue("bar"));\n    });\n})();