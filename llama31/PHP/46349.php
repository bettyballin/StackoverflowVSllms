$p = htmlspecialchars("test of the var");\n?>\n\n<script>\nalert('posts are firing? ');\nparent.document.getElementById('posts').innerHTML = '<?php echo $p; ?>';\n</script>