function show_comments_number($id) {\n    $url = urlencode("index.php?p=post&id=$id");\n?>\n<script>\nvar idcomments_acct = 'xxx';\nvar idcomments_post_id = '<?php echo htmlspecialchars($id); ?>';\nvar idcomments_post_url = '<?php echo htmlspecialchars($url, ENT_QUOTES, 'UTF-8'); ?>';\n</script>\n<script type="text/javascript" src="http://www.intensedebate.com/js/genericLinkWrapperV2.js"></script>\n<?php\n}