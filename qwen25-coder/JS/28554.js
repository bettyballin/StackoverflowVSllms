var id = empid;\n\n$.ajax({\n    type: "POST",\n    url: "../Webservices/EmployeeService.asmx/GetEmployeeOrders",\n    data: JSON.stringify({empid: id}), // Ensure the data is a stringified JSON object\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function(result) {\n        alert(result.d);\n    }\n});