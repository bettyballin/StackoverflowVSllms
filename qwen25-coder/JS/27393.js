$(document).ready(function() {\n    $('#<%= Button1.ClientID %>').click(function(event) {\n        event.preventDefault(); // Prevent default action if form submission is not desired\n        alert('Button clicked');\n        // Additional logic here\n    });\n});