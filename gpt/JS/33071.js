<script>\n$(document).ready(function(){\n    $('#productList li a').click(function(event){\n        event.preventDefault(); // Prevent the default anchor behavior\n        $('#productList li').removeClass('active'); // Remove 'active' class from all list items\n        $(this).parent().addClass('active'); // Add 'active' class to the clicked list item\n    });\n});\n</script>