$(document).ready(function(){\n    $("div.trail-text").attr("style", "display: none;");\n\n    $(".pixie").on('mouseenter', function() {\n        $(this).find("div.trail-text").stop(true, true).slideDown("fast");\n    }).on('mouseleave', function() {\n        $(this).find("div.trail-text").stop(true, true).slideUp("fast");\n    });\n});