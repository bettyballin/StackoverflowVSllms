function next_page() {\n    var sessionId = '<?php echo session_id(); ?>';\n    var form = document.forms[0];\n    form.action = './myuserlist.php?' + '<?php echo session_name(); ?>' + '=' + sessionId;\n    form.submit();\n}