var tmpl = '<option value="${ip}">${ip}</option>';\n    $('#ipAddresses').empty().append($.tmpl(tmpl, {ip: data.d}));