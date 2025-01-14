/// <reference path="/JavaScript/jquery-1.3.2-vsdoc2.js" />\n\n// Simulated 'namespace'\nvar AvonAndSomerset = {}\n\n// Chatroom run time data\nAvonAndSomerset.WebchatV3 = function(memberId, passcode) {\n  this.Members = new Array(); // Members in the chatroom\n  this.Questions = new Array(); // The questions queue in the chatroom\n\n  // Details about the current user\n  this.currentMember = new AvonAndSomerset.WebchatV3.Member(memberId, passcode, null, null, null, null, null);\n\n  // Set-up AJAX defaults\n  $.ajaxSetup({\n    type: "POST",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json"\n  });\n}\n\nAvonAndSomerset.WebchatV3.prototype = {\n    // Get latest Member,Question,Transcript and Room data from server\n    GetUpdate: function(StartUp) {\n      var self = this;  // Store reference to the current instance\n\n      $.ajax({\n        url: "JSON.aspx/Members_GetChanges",\n        data: JSON.stringify({\n          MemberID: self.currentMember.memberId,\n          Passcode: self.currentMember.passcode,\n          ReturnAll: StartUp\n        }),\n        success: function(data, textStatus) {\n          self.GetUpdate_Success(data);  // Use the stored reference\n        },\n        error: function(result) {\n          alert('Members_GetChanges() failed: ' + result.responseText);\n        }\n      });\n    },\n    // Callback - on success of GetUpdate()\n    GetUpdate_Success: function(data) {\n      alert('The AJAX call was successful!');\n    },\n    // Does the MemberID exist in the local array?\n    Members_DoesExist: function(MemberID) {\n      alert('Searching for ' + MemberID);\n      alert(this.Members.length);\n    }\n}