<%# This will be returned and executed in the success callback %>\nvar cid = "<%= @ccj.contact_id %>";\nvar pid = "<%= @ccj.company_id %>";\n$('tr[data-cid="' + cid + '-' + pid + '"]').remove();