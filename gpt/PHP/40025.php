function show_comments_number($id) {\n    $url = "index.php?p=post&id=" . urlencode($id);\n    ?>\n    <script>\n    var idcomments_acct = 'xxx';\n    var idcomments_post_id = '<?php echo $id;?>';\n    var idcomments_post_url = '<?php echo $url;?>';\n    </script>\n    <script type="text/javascript" src="http://www.intensedebate.com/js/genericLinkWrapperV2.js"></script>\n    <?php\n}\n?>