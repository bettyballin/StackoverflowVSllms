// Assuming the iframe has an id of 'myIframe'\n$('#myIframe').on('load', function() {\n    // Access the div with id 'targetDiv' inside the iframe\n    var targetDiv = $(this).contents().find('#targetDiv');\n    \n    console.log(targetDiv);\n});