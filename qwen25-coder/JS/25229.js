$(document).ready(function ready() {\n    $("#MyButton").click(function clicked(e) {\n        e.preventDefault(); // Prevents the default button action\n\n        $.post("Default.aspx/TestMethod",\n            { name: "Bob" },\n            function (msg) {\n                alert("Data Received: " + msg.d); // msg.d to access the data from JSON\n            },\n            "json" // Change datatype to json\n        );\n    });\n});