Event.observe(window, "load", function() {\n    var col1 = $('col1');\n    var col2 = $('col2');\n\n    // Function to get the actual height including padding, border but excluding margin\n    var getHeight = function(element) {\n        return parseInt(element.offsetHeight);\n    };\n\n    // Check for IE 7 and apply a workaround if necessary\n    if (Prototype.Browser.IE && Prototype.Browser.Version < 8.0) {\n        getHeight = function(element) {\n            var height = element.currentStyle['height'];\n            if (height === 'auto') {\n                var dummy = new Element('div', { style: 'position:absolute; top:-9999px;' }).update($(element).innerHTML);\n                document.body.insert(dummy);\n                var computedHeight = dummy.offsetHeight;\n                Element.remove(dummy);\n                return computedHeight;\n            }\n            return parseInt(height, 10);\n        };\n    }\n\n    var col1Height = getHeight(col1);\n    var col2Height = getHeight(col2);\n\n    $('main').setStyle({ height: Math.max(col1Height, col2Height) + 130 + 'px' });\n});