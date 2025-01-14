// Listen to messages sent by the iframe\nwindow.addEventListener('message', function(event) {\n    // Check that the message comes from the expected origin\n    if (event.origin !== 'http://expected-ads-domain.com') return;\n\n    // Process the received data\n    var data = event.data;\n    if(data.action === 'resize') {\n        var iframe = document.getElementById('adIframe');\n        iframe.style.height = data.height + 'px';\n        iframe.style.width = data.width + 'px';\n    }\n}, false);