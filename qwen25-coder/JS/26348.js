function applyDynamicStyles() {\n    var dynamicStyle = "<style type='text/css'>/* Your CSS rules here */</style>";\n    document.getElementsByTagName('head')[0].innerHTML += dynamicStyle;\n}\n\n// Call this function after your AJAX call completes\napplyDynamicStyles();