$.ajax({\n    url: 'submit_to_db.php',\n    type: 'POST',\n    data: {\n        name: name,\n        email: email,\n        comments: comments\n    },\n    success: function(result) {\n        // ...\n    }\n});