$(document).ready(function() {\n    $("#yourFormID").submit(function(event) {\n        event.preventDefault(); // Prevent default form submission\n\n        var emailval = $("#email").val();\n        var invoiceIdval = $("#invoiceId").val();\n\n        $.post("includes/verify.php", \n               {invoiceId: invoiceIdval, email: emailval},\n               function(data) {\n                   console.log(data); // Debug the response\n                   // Process the response here\n               }\n        );\n    });\n});