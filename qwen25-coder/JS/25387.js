javascript:(function(){\n    if(window.location.protocol !== 'https:'){\n        window.alert('This page is not secure. Redirecting...');\n        window.location.href = 'https:' + window.location.href.substring(window.location.protocol.length);\n    } else {\n        console.log('Page is already secured with HTTPS.');\n    }\n})();