$.post("/Controller/AddCustomer", JSON.stringify($("#CustomerFormViewModel").serializeObject()), function (data) {\n    // handle success\n});