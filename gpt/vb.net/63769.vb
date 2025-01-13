Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load\n    If Not IsPostBack Then\n        PopulateDropDownLists()\n        loadInterview()\n    End If\nEnd Sub\n\nPrivate Sub PopulateDropDownLists()\n    ' Populate ddlDay with values 01 to 31\n    For day As Integer = 1 To 31\n        ddlDay.Items.Add(New ListItem(day.ToString("00"), day.ToString("00")))\n    Next\n\n    ' Populate ddlMonth with values 01 to 12\n    For month As Integer = 1 To 12\n        ddlMonth.Items.Add(New ListItem(month.ToString("00"), month.ToString("00")))\n    Next\nEnd Sub\n\nPrivate Sub loadInterview()\n    If String.IsNullOrEmpty(Request.QueryString("iID")) Then\n        Response.Redirect("interviews_list.aspx")\n    Else\n        Dim int As New hh.Interviews\n        int = hh.Interviews.ReturnSingleInterview(Request.QueryString("iID"))\n\n        If int IsNot Nothing Then\n            ddlDay.SelectedValue = int.InterviewDate.Day.ToString("00")\n            ddlMonth.SelectedValue = int.InterviewDate.Month.ToString("00")\n            txtYear.Text = int.InterviewDate.Year.ToString()\n\n            txtPerson.Text = int.InterviewPerson\n            txtTitle.Text = int.InterviewTitle\n            txtText.Text = int.InterviewText\n        End If\n    End If\nEnd Sub