$('#div').hover(\n      function(){\n           $(this).addClass('cie_hover');\n           $('#otherdiv').slideDown();\n      }, function(){\n           $(this).removeClass('cie_hover');\n           $('#otherdiv').slideUp();\n      }\n );