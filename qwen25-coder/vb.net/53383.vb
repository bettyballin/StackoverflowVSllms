Imports System.Web\n\nPublic Class WebLanguagePreferenceProvider Implements ILanguagePreferenceProvider\n    Public Function GetUserPreferredLanguage() As String Implements ILanguagePreferenceProvider.GetUserPreferredLanguage\n        If HttpContext.Current IsNot Nothing Then\n            ' Example of getting the language from cookies, headers or user settings\n            Return HttpContext.Current.Request.UserLanguages(0)\n        End If\n        Return "en" ' Default language if not found\n    End Function\nEnd Class