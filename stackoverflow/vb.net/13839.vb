If rcount < 10 Then\n     rcount = rcount + 1\n     RtxtMessage.ScrollBars = RichTextBoxScrollBars.None\n     RtxtMessage.Text = RtxtMessage.Text + " " + \n     CType(dv.Item(i)("audit_message"), String) & vbCrLf\n End If