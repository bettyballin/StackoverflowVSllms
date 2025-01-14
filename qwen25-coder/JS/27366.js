function CheckUserMembership() {\n    var clientContext = new SP.ClientContext.get_current();\n    var web = clientContext.get_web();\n    var currentUser = web.get_currentUser();\n    clientContext.load(currentUser);\n\n    var groupId = GetGroupId(web, 'Print Users', function(groupId) {\n        if (groupId !== null && IsCurrentUserInGroup(currentUser, groupId)) {\n            // Show the custom action\n            document.getElementById('customActionId').style.display = '';\n        } else {\n            // Hide the custom action\n            document.getElementById('customActionId').style.display = 'none';\n        }\n    });\n\n    clientContext.executeQueryAsync(function() {}, function(sender, args) {\n        console.error("Error: " + args.get_message());\n    });\n}\n\nfunction GetGroupId(web, groupName, callback) {\n    var groups = web.get_siteGroups();\n    var groupEnumerator = groups.getEnumerator();\n\n    while (groupEnumerator.moveNext()) {\n        var group = groupEnumerator.get_current();\n        if (group.get_title() === groupName) {\n            return callback(group.get_id());\n        }\n    }\n\n    return callback(null);\n}\n\nfunction IsCurrentUserInGroup(user, groupId) {\n    var clientContext = new SP.ClientContext.get_current();\n    var groups = user.get_groups();\n    clientContext.load(groups);\n\n    clientContext.executeQueryAsync(function() {\n        var groupEnumerator = groups.getEnumerator();\n        while (groupEnumerator.moveNext()) {\n            if (groupEnumerator.get_current().get_id() === groupId) {\n                return true;\n            }\n        }\n        return false;\n    }, function(sender, args) {\n        console.error("Error: " + args.get_message());\n    });\n}\n\n// Execute the check on page load\nSP.SOD.executeFunc('sp.js', 'SP.ClientContext', CheckUserMembership);