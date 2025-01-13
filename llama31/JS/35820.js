$.ajax({\n    type: 'POST',\n    url: '@Url.Action("VoteUp", "Posts")',\n    data: JSON.stringify({ postId: 5 }),\n    contentType: 'application/json; charset=utf-8',\n    dataType: 'json',\n    success: function(data) {\n        if (data.success) {\n            // Update the vote count in the UI\n            $('#vote-count').text(data.voteCount);\n        } else {\n            // Handle the error\n            console.error(data.message);\n        }\n    }\n});