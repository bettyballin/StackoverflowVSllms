$('.entries').each(function() {\n  var $this = $(this);\n  $this.find('img').on('load', function() {\n    $this.attr("value", $this.outerHeight() + 15);\n  });\n});