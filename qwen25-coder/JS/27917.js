function getProducts(Category) {\n  $.ajax({\n    type: "GET",\n    url: "getInfo.cfm",\n    data: "Action=getProducts&Category=" + Category,\n    success: function(result){\n      // Prepend a default option and update with AJAX result\n      $("#Products").html('<option value="">Select Product</option>' + result);\n      // Set the selected index to 0 (the default option)\n      $('#Products')[0].selectedIndex = 0;\n    }\n  });\n}