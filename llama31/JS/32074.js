if (window.confirm("Are you sure you want to delete that record?")) {\n  $.ajax({\n    type: "POST",\n    url: "delete_record.php",\n    data: { id: '<?php echo $id; ?>' },\n    success: function(response) {\n      if (response === "success") {\n        window.location.href = "dashboard.php";\n      } else {\n        alert("Error deleting record: " + response);\n      }\n    }\n  });\n}