jQuery(document).ready(function($) {\n  // Intercept link creation in the editor\n  $('#content').on('input', function() {\n    $('a[href]', this).each(function() {\n      if (!$(this).attr('target')) {\n        $(this).attr('target', '_blank');\n      }\n    });\n  });\n});