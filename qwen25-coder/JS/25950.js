var xhr = new XMLHttpRequest();\nxhr.open('GET', 'http://example.com/destination', true);\nxhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');\nxhr.setRequestHeader('Referer', 'http://www.your-custom-referer.com'); // Spoofed Referer\nxhr.onload = function() {\n    if (this.status === 200) {\n        console.log(this.responseText);\n    }\n};\nxhr.send();