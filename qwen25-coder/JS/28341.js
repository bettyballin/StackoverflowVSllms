<script type="text/javascript">\nfunction confirmDelete(id) {\n    if(window.confirm("Are you sure you want to delete that record?")) { \n        // Create an XMLHttpRequest object or use Fetch API (modern browsers)\n        fetch('deleteRecord.php', {\n            method: 'POST',\n            headers: {\n                'Content-Type': 'application/x-www-form-urlencoded',\n            },\n            body: 'id=' + encodeURIComponent(id),\n        })\n        .then(response => response.text())\n        .then(data => {\n            if(data === "success") {\n                alert("Record deleted successfully");\n                window.location.href = "dashboard.php";\n            } else {\n                alert("Error deleting record");\n            }\n        })\n        .catch(error => console.error('Error:', error));\n    }\n}\n</script>