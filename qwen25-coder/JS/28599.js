var ndomain = document.domain; // This will return 'level1.test.foo.com' if on that subdomain\nvar mydomain = 'www.foo.com';\nvar alink = document.getElementsByTagName('a');\nfor (var i = 0; i < alink.length; i++) {\n    if (alink[i].href && alink[i].host.startsWith(mydomain)) { // Use startsWith for cleaner code\n        alink[i].href = alink[i].href.replace(mydomain, ndomain); // Directly replace the URL part to ensure host is updated correctly\n    }\n}