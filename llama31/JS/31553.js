$(document).ready(function(){\n  $("div.trail-text").attr("style", "display: none;");\n\n  if ($(".pixie")) {\n    $(".pixie").hover(function() {\n      $(this).find("div.trail-text").slideDown("fast")\n    }, function() {\n      $(this).find("div.trail-text").slideUp("fast")\n    });\n  };\n});