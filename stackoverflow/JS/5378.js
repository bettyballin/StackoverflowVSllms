$('li.alpha-init').click(function(){\n    $('ul#'+this.id.substr(1) + "-sub").slideToggle(200);\n}