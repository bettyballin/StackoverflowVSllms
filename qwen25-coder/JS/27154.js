function submitAction() {\n    var paramList = "Action=make_process";\n\n    $.ajax({\n        url: "ord_process.php",\n        type: 'POST',\n        data: paramList,\n        error: function(){\n            msgObj.innerHTML = '<div style="width:313px; padding-top:40px;"><p class="cAlign">Connection error.<br>Please try again.</p></div>';\n        },\n        success: function(data){\n            var endDateTime = getCurrentDateTime();\n            msgObj.innerHTML = ''; \n            alert("  "+data+"\n\n  Start Date&Time : "+startDateTime+"\n    End Date&Time : "+endDateTime);\n        }   \n    });    \n}\n\nfunction getUpdatedJobRecord() {\n    var paramList = "Action=get_job_record&call=ajax";\n\n    $.ajax({\n        url: "ord_process.php",\n        type: 'POST',\n        data: paramList,\n        error: function(){\n            msgObjB.innerHTML = update_date;\n            msgObjA.innerHTML = '<td><div style="width:313px; padding-top:40px;"><p class="cAlign">Connection error.<br>Please try again.</p></div></td>';\n        },\n        success: function(data){\n            msgObjB.innerHTML = update_date;\n            msgObjA.innerHTML = data;\n        }       \n    }); \n}\n\nvar myInterval = setInterval(getUpdatedJobRecord, 5000); // Corrected the function call