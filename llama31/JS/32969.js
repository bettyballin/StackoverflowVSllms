// Show the loader when the page starts loading\n$(document).ready(function () {\n    $('#loader').show();\n});\n\n// Hide the loader when the page finishes loading\n$(window).load(function () {\n    $('#loader').hide();\n});