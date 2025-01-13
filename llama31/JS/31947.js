var init = function(){\n    var contentNode = dojo.byId("content");\n    dojo.xhrGet({\n        url: "js/sample.txt",\n        handleAs: "text",\n        load: function(data, args){\n            // args contains additional information about the request\n            console.log(args); // output: { xhr: XMLHttpRequest, url: "js/sample.txt", ... }\n            // fade out the node we're modifying\n            dojo.fadeOut({\n                node: contentNode,\n                onEnd: function(){\n                    // set the data, fade it back in\n                    contentNode.innerHTML = data; \n                    dojo.fadeIn({ node: contentNode }).play();    \n                }\n            }).play();\n        },\n        // if any error occurs, it goes here:\n        error: function(error, args){\n            console.warn("error!", error);\n            console.log(args); // output: { xhr: XMLHttpRequest, url: "js/sample.txt", ... }\n        }\n    });\n};\ndojo.addOnLoad(init);