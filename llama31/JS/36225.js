// assuming you have jQuery included\n$(document).ready(function() {\n  var baseUrl = "http://www.domain.com";\n  $('a').each(function() {\n    var href = $(this).attr('href');\n    if (href.indexOf('/') === 0) { // check if href starts with '/'\n      $(this).attr('href', baseUrl + href);\n    }\n  });\n});