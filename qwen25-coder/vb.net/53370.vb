con()\nsqry = "SELECT emp_no, first_name + ' ' + last_name AS full_name FROM your_table_name"\nsqcom = New SqlCommand(sqry, sqcon)\nda.SelectCommand = sqcom\n\nds.Clear()\nda.Fill(ds)\nddl_adv.DataSource = ds\nddl_adv.DataTextField = "full_name" ' Changed to the new concatenated field name\nddl_adv.DataValueField = "emp_no"\n\nddl_adv.DataBind()\nsqcon.Close()