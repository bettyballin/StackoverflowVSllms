$(document).ready(function(){\n  $.ajax({\n    url: "textes.html",\n    cache: false,\n    success: function(html){\n      var $html = $(html);\n      $("#right").append($html.filter("#a, #b, #c, #d, #e, #f"));\n    }\n  });\n});