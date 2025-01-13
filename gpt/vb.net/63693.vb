Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load\n    If Not Page.IsPostBack Then\n        lbltime.Visible = IncludeTime\n\n        If SelectedDateTime.CompareTo(DateTime.MinValue) > 0 Then\n            txtDate.Text = SelectedDateTime.Date.ToShortDateString()\n            txtHour.Text = SelectedDateTime.Hour.ToString("D2")\n            txtMinute.Text = SelectedDateTime.Minute.ToString("D2")\n            txtSecond.Text = SelectedDateTime.Second.ToString("D2")\n        End If\n    End If\nEnd Sub