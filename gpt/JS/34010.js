<script type="text/javascript">\n    function getSessionData() {\n        $.ajax({\n            type: "POST",\n            url: "YourPage.aspx/GetSessionData",\n            contentType: "application/json; charset=utf-8",\n            dataType: "json",\n            success: function (response) {\n                console.log(response.d); // Output: JohnDoe\n            },\n            error: function (response) {\n                console.error('Error:', response);\n            }\n        });\n    }\n    \n    // Call the function to get the session data\n    getSessionData();\n</script>