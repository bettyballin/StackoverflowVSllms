var party = {\n    RsvpCode: 1,\n    Guests: [\n        { Name: "test asdfasdf", MealOption: 1, Attending: true },\n        { Name: "test asdfasdf", MealOption: 1, Attending: true }\n    ],\n    Comments: "testdsfsdf"\n};\n\n$.ajax({\n    url: "/Rsvp/Submit",\n    type: "POST",\n    contentType: "application/json; charset=utf-8",\n    data: JSON.stringify(party),\n    dataType: "json",\n    success: function (response) {\n        alert(JSON.stringify(response));\n    },\n    error: function (xhr, status, error) {\n        console.log("Error: " + error);\n    }\n});