Dim m_Title As String\n\nDim m_DateValue As String ' Using "DateValue" instead of "Date"\n\nPublic Property Title() As String\n    Get\n        Return m_Title\n    End Get\n    Set(ByVal value As String)\n        m_Title = value\n    End Set\nEnd Property\n\nPublic Property ReportDate() As String ' Using "ReportDate" to indicate that this is a date related to reports\n    Get\n        Return m_DateValue\n    End Get\n    Set(ByVal value As String)\n        m_DateValue = value\n    End Set\nEnd Property