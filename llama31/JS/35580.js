for (i = 0; i < aTags.length; i++) {\n    var data = aTags[i].href.match(uriPattern);\n    if (data != null && data.length > 1 && data[2] != "preview") {\n        var source = data[1];\n        var fragment = data[2];\n        var link = aTags[i];\n        (function(link, fragment) {\n            link.addEventListener("mouseover", function() {\n                if (link.title == "") {\n                    (providers[source])(link, fragment);\n                }\n            }, false);\n        })(link, fragment);\n    }\n}