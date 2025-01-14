(function() {\n    var scripts = document.getElementsByTagName('script');\n    var currentScriptSrc = scripts[scripts.length - 1].getAttribute('src');\n    var scriptName = currentScriptSrc.substring(currentScriptSrc.lastIndexOf('/') + 1);\n\n    if (typeof jQuery !== "function") {\n        throw new Error(\n            "jQuery's script needs to be loaded before " + \n            scriptName + ". Check the <script> tag order."\n        );\n    }\n})();