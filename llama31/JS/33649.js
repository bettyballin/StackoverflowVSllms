$('.number-only').keypress(function(event) {\n    var $this = $(this);\n    if ((event.which != 46 || $this.val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {\n        event.preventDefault();\n    }\n});