function test() {\n    var d = new doh.Deferred();\n\n    d.addCallback(function() {  \n        Comm.logout(); /* synchronus */\n        try {   \n            // check with doh.t and doh.is\n            return true;\n        } catch (e) {\n            d.errback(e);\n        }\n    });\n\n    d.addCallback(function() {\n        var d2 = new dojo.Deferred();\n        /* asynchronus - third parameter is a callback */\n        Comm.login('alex', 'asdf', function(result, msg) {\n                try {\n                    // check with doh.t and doh.is\n                    d2.callback(true);\n                } catch (e) {\n                    d2.errback(e);\n                }                   \n            });\n        return d2; // returning doh.Defferred -- expect d to wait for d2.callback\n    });\n\n    /* asynchronus - third parameter is a callback */\n    Comm.login('larry', '123', function (result, msg) {\n        try {\n            // check with doh.t and doh.is \n            d.callback(true);\n        } catch (e) {\n            d.errback(e);\n        }\n    });\n\n    // Wait for the entire callback chain to complete\n    return d.then(function() {\n        return d;\n    });\n}