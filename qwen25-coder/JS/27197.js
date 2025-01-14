$(document).ready(function() {\n    // Initialize idTabs with mouseover event\n    $(".idTabs").idTabs("!mouseover");\n\n    // Attach click event handler to links\n    $(".idTabs a").on('click', function(e) {\n        var redirectUrl = $(this).data('redirect');\n        if (redirectUrl) {\n            e.preventDefault(); // Prevent the default navigation behavior\n            window.location.href = redirectUrl; // Redirect to the specified URL\n        }\n    });\n});