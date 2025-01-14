$(document).ready(function() {\n  $('.image-link').click(function(event) {\n    event.preventDefault();\n    \n    // Remove 'active' class from all links\n    $('.image-link').removeClass('active');\n    \n    // Add 'active' class to the clicked link\n    $(this).addClass('active');\n    \n    // Load the content via AJAX\n    var url = $(this).attr('href');\n    $('#content-area').load(url);\n  });\n});