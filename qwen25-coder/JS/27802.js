// This is a hypothetical script illustration and will not run as-is in Firefox.\n// Use FoxyProxy or similar extensions for real functionality.\n\nfunction toggleProxy() {\n    var currentSetting = getBrowserPreferences("network.proxy.type");\n    if (currentSetting === 0) { // No proxy\n        setBrowserPreference("network.proxy.type", 1); // Manual proxy configuration\n        setBrowserPreference("network.proxy.http", "your.home.proxy.server");\n        setBrowserPreference("network.proxy.http_port", 8080);\n    } else {\n        setBrowserPreference("network.proxy.type", 0); // No proxy\n    }\n}\n\nfunction getBrowserPreferences(preferenceName) {\n    var prefs = Components.classes["@mozilla.org/preferences-service;1"]\n                          .getService(Components.interfaces.nsIPrefService)\n                          .getBranch("");\n    if (prefs.prefHasUserValue(preferenceName)) {\n        return prefs.getIntPref(preferenceName);\n    } else {\n        return null;\n    }\n}\n\nfunction setBrowserPreference(preferenceName, value) {\n    var prefs = Components.classes["@mozilla.org/preferences-service;1"]\n                          .getService(Components.interfaces.nsIPrefService)\n                          .getBranch("");\n    prefs.setIntPref(preferenceName, value);\n}