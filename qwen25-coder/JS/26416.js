<script>\n$(function() {\n    var deleteItemId;\n\n    // This function is called when the delete button is clicked\n    function showDeleteConfirmation(id) {\n        deleteItemId = id; // Store the item ID\n        $('#confirmDeleteModal').modal('show'); // Show the modal\n    }\n\n    // This event handler is triggered when the user clicks "Yes, Delete"\n    $('#confirmDeleteBtn').click(function() {\n        $.ajax({\n            url: '/YourController/Delete',\n            type: 'POST',\n            data: { id: deleteItemId },\n            success: function(result) {\n                if (result.success) {\n                    // Optionally handle successful deletion\n                    alert('Item deleted successfully.');\n                    $('#confirmDeleteModal').modal('hide');\n                    // Refresh the page or update the UI accordingly\n                } else {\n                    alert('Failed to delete item.');\n                }\n            },\n            error: function() {\n                alert('An error occurred while trying to delete the item.');\n            }\n        });\n    });\n\n    // Example of how you might trigger showDeleteConfirmation from your delete button\n    $('.delete-button').click(function() {\n        var id = $(this).data('item-id'); // Assuming each button has a data attribute with the ID\n        showDeleteConfirmation(id);\n    });\n});\n</script>