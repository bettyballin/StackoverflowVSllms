ew Ajax.Request('testurl', {\n  method: 'post',\n  parameters: { param1: "A", param2: "B", param3: "C" },\n  onSuccess: fnSccs.bind(this, 'additionalArgument'),\n  onFailure: fnFail\n});\n\nfunction fnSccs(additionalArgument, response) {\n  alert(response.responseText);\n  // use additionalArgument here\n}