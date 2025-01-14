<?php echo $html->link(\n    'Delete',\n    array('controller' => 'forms', 'action' => 'delete', $r['Form']['id']),\n    array('class' => 'delete-link'),\n    __('Are you sure you want to delete this form?', true),\n    false\n); ?>\n\n<script>\n$(document).ready(function() {\n    $('.delete-link').click(function(event) {\n        if (confirm(__("Are you sure you want to delete this form?", true))) {\n            $.ajax({\n                url: $(this).attr('href'),\n                type: 'POST', // Adjust the method according to your needs\n                success: function(response) {\n                    alert(__('Your form has been deleted.', true));\n                    // Optionally, reload the page or remove the element from DOM\n                    // window.location.reload();\n                },\n                error: function() {\n                    alert(__('There was an error deleting the form.', true));\n                }\n            });\n        }\n        event.preventDefault(); // Prevent the default action to allow AJAX handling\n    });\n});\n</script>