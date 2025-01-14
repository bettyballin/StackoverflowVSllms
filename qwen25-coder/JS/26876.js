function callCancelPlan(activePlanId, ntLogin) {\n    var paramList = JSON.stringify({ activePlanId: activePlanId, ntLogin: ntLogin });\n    $.ajax({\n        type: "POST",\n        url: "ArpWorkItem.aspx/CancelPlan",\n        data: paramList,\n        contentType: "application/json; charset=utf-8",\n        dataType: "json",\n        success: function(response) {\n            alert("success");\n        },\n        error: function(xml, textStatus, errorThrown) {\n            alert(xml.status + "||" + xml.responseText);\n        }\n    });\n}