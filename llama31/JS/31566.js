$("#subJobName").prop("jval", {\n  valid: function(val) { return validateSubJobName(val); },\n  message: "Name already exists or is longer than 14 characters.",\n  styleType: "cover"\n});