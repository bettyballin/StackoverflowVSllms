$(function() {\n\n  // Way 1\n  function doosomething()\n  {\n    //Doo something\n  }\n\n  // Way 2, equivalent to Way 1\n  var doosomething = function() {\n    // Doo something\n  }\n\n  $("div.class").click(doosomething);\n\n  $("div.secondclass").click(doosomething);\n\n});