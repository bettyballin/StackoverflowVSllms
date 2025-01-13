$(document).on('click', 'a.order_by', function(event) {\n  event.preventDefault();\n\n  var $this = $(this);\n  var targets = $this.data('update-target').split(',');\n\n  $.get(this.href, function(data) {\n    targets.forEach(function(target) {\n      $(target).html($(data).find(target).html());\n    });\n  });\n});