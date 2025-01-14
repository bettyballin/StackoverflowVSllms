$(document).ready(function() {\n    $("#form-comments-<%= Html.Encode(Model.Issue.IssueId) %>").submit(function(evt) {            \n        evt.preventDefault(); // Prevent default form submission\n        var frm = $("#form-comments-<%= Html.Encode(Model.Issue.IssueId) %>");\n        var action = frm.attr("action");\n        var serializedForm = frm.serialize();\n        var comments = jQuery.trim($("#form-comment-<%= Html.Encode(Model.Issue.IssueId) %>").val());\n        if (comments.length < 1)\n            return;\n        AjaxPostComment("<%= Html.Encode(Model.Issue.IssueId) %>", comments);\n    });\n});