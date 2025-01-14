$(document).ready(function() {\n    $("#form-comments-<%= Html.Encode(Model.Issue.IssueId) %>").submit(function(evt) {\n        evt.preventDefault(); // Prevent the default form submission behavior\n\n        var frm = $(this);\n        var action = frm.attr("action");\n        var serializedForm = frm.serialize();\n\n        $.ajax({\n            type: "POST",\n            url: action,\n            data: serializedForm,\n            success: function(data) {\n                // Assuming 'data' contains the updated partial view with comments\n                $('#comments-container').html(data);\n                // Clear the comment input field after successful submission\n                $('#form-comment-<%= Html.Encode(Model.Issue.IssueId) %>').val('');\n            },\n            error: function(xhr, status, error) {\n                // Handle error here\n                console.log("An error occurred: " + error);\n            }\n        });\n    });\n});