onWindowClose: function(e) {\n    if (...) {\n        e.returnValue = 'Your custom message here';\n        YAHOO.util.Event.preventDefault(e);\n    }\n}