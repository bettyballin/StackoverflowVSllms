$(function(){\n  $('select.cat_dropdown').change(function(){\n     $('.item :checkbox').removeAttr('checked'); //uncheck the other boxes\n     $('.item :checkbox')[this.selectedIndex-1].checked = true;\n  });\n});