$(document).ready(function() {\n  $('code').each(function() {\n    var code = $(this).text();\n    code = code.replace(/&/g, '&amp;')\n               .replace(/</g, '&lt;')\n               .replace(/>/g, '&gt;')\n               .replace(/"/g, '&quot;')\n               .replace(/'/g, '&#39;');\n    $(this).html(code);\n  });\n});