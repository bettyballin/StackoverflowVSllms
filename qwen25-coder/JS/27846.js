<script type="text/javascript">\nfunction updateScore( answer )\n{\n    var userid = '<?php echo $user_id; ?>';\n    var obid = '<?php echo $status_id; ?>';\n    var authoruserid = '<?php echo $aid; ?>';\n\n    if ( confirm( "Are you sure?" ) )\n    {\n        $.post('index.php', {user_id: userid, ob_id: obid, author_user_id: authoruserid}, function(d)\n        {\n            alert('Vote Accepted: ' + d);\n            $(answer).after("<span>You Voted!</span>").remove();\n        });\n    }\n}\n</script>