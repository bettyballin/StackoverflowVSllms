jQuery(document).ready(function() {\n\n  jQuery('#storeListTable tr').click(function() {\n\n    jQuery.post("get_storeData.php", { storeID: this.cells[0].innerHTML },     // this.cells[0].innerHTML is the content ofthe first cell in selected table row\n      function(data){\n         alert(data[0].name);\n      }, "json");\n    });\n\n});