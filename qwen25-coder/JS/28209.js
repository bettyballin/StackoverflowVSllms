<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>\n<script>\n$(document).ready(function() {\n    $('form').submit(function(event) {\n        this.target = '_self';\n    });\n});\n</script>\n\n<% using (Html.BeginForm()) { %>\n    <!-- Your form fields here -->\n    <input type="text" name="example" />\n    <button type="submit">Submit</button>\n<% } %>