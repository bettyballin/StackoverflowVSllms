// pretend you have links in your page <a href="link.htm" rel="external">Link</a>\n// please note that the rel-value can be chosen at will\n$(document).ready(function(){\n    $('a[rel="external"]').click(function() {\n        window.open(this.href, '_blank');\n        return false;\n    });\n});