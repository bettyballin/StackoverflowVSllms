<script src="/js/Prototype.js">\n    //calls renderResponse on completion of the AJAX post to the specified URL\n    function sendRequest(parameters,URLEndpoint){\n        var myAjax = new Ajax.Request\n                     (\n                         URLEndpoint,\n                         {\n                             method: 'post', \n                             postBody: parameters, \n                             onSuccess: renderResponse\n                         }\n                     );\n    }\n\n    //replace contents of 'character' div or whatever with output from PHP script\n    function renderResponse(response){\n       var el = $(characterTable); \n       elementId.innerHTML = resp.responseText;\n    }\n\n    //execute sendRequest every 2 seconds\n    function periodicalUpdate() {\n        new PeriodicalExecuter(sendRequest('monkeys=2&carrots=7','http://mywebsite.com/game.php'), 2);\n    }