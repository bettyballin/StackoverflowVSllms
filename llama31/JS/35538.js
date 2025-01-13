// Ensure that each content <span> is sized to fit the width of the scrolling region.\n// (When there is no horizontal scrollbar, use the width of the parent.)\nfixContentSpans : function() {\n    jQuery('.syntaxhighlighter > div.lines').each(function(){\n        var container = jQuery(this);\n        var scrollWidth = this.scrollWidth;\n        var width = jQuery(this).width();\n        var contents = container.find('.content');\n        jQuery(contents).each(function(){\n            var child = jQuery(this);\n            var widthAvail = \n                scrollWidth - parseFloat(child.css("margin-left"))  \n                - parseFloat(child.css("padding-left"))\n                - parseFloat(child.css("padding-right"));\n            var borderLeft = parseFloat(child.css("border-left-width"));\n            // IE uses names (e.g. "medium") for border widths, resulting in NaN\n            // when we parse the value.  Rather than trying to get the numeric\n            // value, we'll treat it as 0. This may add a few additional pixels \n            // in the scrolling region, but probably not enough to worry about.\n            if (!isNaN(borderLeft)) {\n                widthAvail -= borderLeft;\n            }\n            child.width(widthAvail);\n        });\n    });\n},