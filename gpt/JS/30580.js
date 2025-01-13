var UI = {\n  Layouts: {\n    ShowLayoutSettings: function(pid, lid) {\n      My.PageServices.GetPageLayout(lid, pid, UI.Layouts._onShowLayoutSettings, UI.Layouts._onError);\n    },\n    _onShowLayoutSettings: function(obj) {\n      console.log("Callback received: ", obj);\n      if (obj) {\n        alert(obj.ID);\n      } else {\n        alert('No data received');\n      }\n    },\n    _onError: function(error) {\n      console.error("Error during AJAX call: ", error);\n    }\n  }\n};\n\ndocument.querySelector("a").addEventListener("click", function() {\n  UI.Layouts.ShowLayoutSettings(5, 2);\n});