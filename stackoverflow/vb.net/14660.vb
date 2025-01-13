ReportViewer1.Reset()\n    Dim dt As DataTable\n    dt = DirectCast(Form1.ProgActnBindingSource.Current, DataRowView).DataView.ToTable\n\n    Dim rs = New ReportDataSource\n    rs.Name = "name"\n    rs.Value = dt\n\n    ReportViewer1.ProcessingMode = ProcessingMode.Local\n    ReportViewer1.LocalReport.DataSources.Clear()\n    ReportViewer1.LocalReport.DataSources.Add(rs)\n    ReportViewer1.LocalReport.ReportEmbeddedResource = "projectname.Report1.rdlc"\n\n    Me.ReportViewer1.RefreshReport()