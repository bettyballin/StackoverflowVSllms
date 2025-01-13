$(document).ready(function() {\n  $('.custom-select').each(function() {\n    var $this = $(this);\n    var $ul = $this.find('ul');\n    var $selectedValue = $this.find('.selected-value');\n    var $hiddenInput = $this.find('input[type="hidden"]');\n\n    $ul.on('click', 'li', function() {\n      var $li = $(this);\n      $selectedValue.text($li.text());\n      $hiddenInput.val($li.attr('value'));\n      $ul.hide();\n    });\n\n    $selectedValue.on('click', function() {\n      $ul.toggle();\n    });\n  });\n});