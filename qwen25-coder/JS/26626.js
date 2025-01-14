$(document).ready(function() {\n    $('.content_box').hide();\n    $('.sf-menuUP a').click(function(){\n        $('.content_box').fadeIn('slow');\n    });\n\n    var hash = window.location.hash.substr(1);\n    var href = $('.sf-menuUP li a').each(function(){\n        var href = $(this).attr('href');\n        if(hash==href.substr(0,href.length-5)){\n            var toLoad = hash+'.html #content';\n            loadContent(toLoad); // Use the same function to avoid code duplication\n        }                                           \n    });\n\n    $('.sf-menuUP li a').click(function(){\n        var toLoad = $(this).attr('href')+' #content';\n        $('#content').fadeOut('fast', function() { // Directly call loadContent in the callback\n            loadContent(toLoad);\n        });\n        $('#load').remove();\n        $('#wrapper').append('<span id="load">LOADING...</span>');\n        $('#load').fadeIn('normal');\n        window.location.hash = $(this).attr('href').substr(0,$(this).attr('href').length-5);\n        return false;\n    });\n\n    function loadContent(toLoad) {\n        $('#content').load(toLoad, '', function() { // This is where the content is loaded\n            showNewContent();\n            initializeSlimbox(); // Call this to rebind slimbox\n        });\n    }\n\n    function showNewContent() {\n        $('#content').fadeIn('normal', hideLoader);\n    }\n\n    function hideLoader() {\n        $('#load').fadeOut('normal');\n    }\n\n    function initializeSlimbox() { // Function to initialize or reinitialize Slimbox2\n        $("a[rel^='lightbox']").slimbox({/* Put custom options here */}, null, function(el) {\n            return (this == el) || ((this.rel.length > 8) && (this.rel == el.rel));\n        });\n    }\n\n    // Initialize slimbox initially if necessary\n    initializeSlimbox();\n});