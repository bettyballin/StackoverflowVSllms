$(function() {\n  var onajax = function(e, xhr, settings) {\n    if (e.target.id === 'a') {\n      // do something specific for div#a\n    } else if (e.target.id === 'b') {\n      // do something specific for div#b\n    }\n  };\n\n  $('#a, #b').ajaxSend(onajax).click(function() {\n    $(this).load('foobar');\n  });\n});