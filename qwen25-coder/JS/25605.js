jQuery(document).ready(function() { \n  jQuery('#storeListTable tr').click(function() {\n    var storeID = this.cells[0].innerHTML;\n    \n    jQuery.post("get_storeData.php", { sID: storeID }, \n      function(data) {\n         if (data && data.length > 0) {\n             alert(data[0].name); // Access the name property of the first object\n         } else {\n             alert('No data found');\n         }\n      }, "json"); \n  });\n});