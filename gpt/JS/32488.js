$(document).ready(function() {\n  $('.nav-item').hover(\n    function() {\n      // On mouse enter\n      $(this).find('.bg-image').stop().animate({ top: '0%' }, 300);\n    },\n    function() {\n      // On mouse leave\n      $(this).find('.bg-image').stop().animate({ top: '-100%' }, 300);\n    }\n  );\n});