// Example jQuery to add a new grid item dynamically\n$(document).ready(function() {\n    $('#addGridItem').click(function() {\n        $('#gridContainer').append('<div class="grid-item">New Item</div>');\n    });\n});