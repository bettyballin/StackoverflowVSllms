function getClientInfo() {\n    var timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;\n    var culture = navigator.language || navigator.userLanguage;\n    \n    // Send the timezone and culture to your web service\n    // using an AJAX request or another method\n    console.log(timezone);\n    console.log(culture);\n}\n\ngetClientInfo();