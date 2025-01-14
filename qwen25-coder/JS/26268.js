// In X.html\ndocument.addEventListener('DOMContentLoaded', function() {\n    // Assuming someCondition is your condition to decide whether to open Y.html\n    var someCondition = true; // This should be replaced with actual logic\n\n    if (someCondition) {\n        sessionStorage.setItem('referrer', window.location.href);\n        window.location.href = 'Y.html';\n    }\n});\n\n// In Y.html\ndocument.addEventListener('DOMContentLoaded', function() {\n    var referrer = sessionStorage.getItem('referrer');\n    if (!referrer || referrer === 'Y.html') {\n        // Fallback URL in case there's no referrer or it's incorrect\n        window.location.href = 'X.html';\n    }\n});