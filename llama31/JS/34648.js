// testrunner.js\nconst QUnit = require('qunitjs');\n\nQUnit.load();\nQUnit.config.autostart = false;\n\nrequire('./tests');\n\nQUnit.start();