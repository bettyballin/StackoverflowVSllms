<script type="text/javascript">\n$(document).ready(function() {\nsetInterval(function()\n{\n     $('#uploadcount').fadeOut("fast").load('uploadcount.php').fadeIn("slow");\n}, 10000);\n\n});\n</script>\n\n\n<div id="uploadcount">\n<? include("uploadcount.php");?>\n</div>