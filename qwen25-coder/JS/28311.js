error: function() {\n       load_area.html('<div id="response">Error loading data.</div>');\n       jQuery('#loading').fadeOut(500, function() { jQuery(this).remove(); });\n   }