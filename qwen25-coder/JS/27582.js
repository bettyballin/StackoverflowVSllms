$('#yourLayerId').fadeIn(1000, function() { // Adjust duration as needed\n    if ($.browser.msie && $.browser.version < 8) {\n        $(this).css('filter', 'alpha(opacity=50)');\n    } else {\n        $(this).css('opacity', '0.5');\n    }\n});\n\n$('#yourLayerId').fadeOut(1000, function() { // Adjust duration as needed\n    if ($.browser.msie && $.browser.version < 8) {\n        $(this).css('filter', '');\n    } else {\n        $(this).css('opacity', '');\n    }\n});