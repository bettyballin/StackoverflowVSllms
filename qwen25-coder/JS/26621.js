var personData = {\n    FirstName: 'John',\n    LastName: 'Doe',\n    Address: '123 Elm St',\n    PhoneNum: '555-1234',\n    Email: 'john.doe@example.com',\n    PostalCode: '12345',\n    City: 'Springfield',\n    Province: 'IL',\n    Country: 'USA'\n};\n\n$.ajax({\n    url: '/YourController/Create', // Adjust the URL to your specific controller/action\n    type: 'POST',\n    data: JSON.stringify(personData),\n    contentType: 'application/json; charset=utf-8',\n    dataType: 'json',\n    success: function(response) {\n        if (response.success) {\n            console.log('Person created successfully.');\n        } else {\n            console.error('Errors:', response.errors);\n        }\n    },\n    error: function(xhr, status, error) {\n        console.error('Request failed:', error);\n    }\n});