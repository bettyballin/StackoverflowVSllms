<script type="text/javascript">\njQuery(document).ready(function($) {\n    function applyHover() {\n        $("#container ul#thumbnails li a").hover(\n            function(){\n                var largePath = $(this).attr("name");\n                $("#container #main_image img#largeId").attr({ src: largePath });\n            }\n        );\n    }\n\n    $("a.group").fancybox({\n        'frameWidth': 966,\n        'frameHeight': 547,\n        'hideOnContentClick': false,\n        // Ensure the function is called correctly\n        'afterShow': applyHover\n    });\n});\n</script>