// Client-side (JavaScript)\n$.ajax({\n    type: "GET",\n    url: "/api/data",\n    success: function(data) {\n        console.log(data); // Output: [{ Id: 1, Name: "John" }, { Id: 2, Name: "Jane" }]\n        // Update your UI with the received data\n    }\n});