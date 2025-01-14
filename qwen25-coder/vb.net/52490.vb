Imports System.Configuration\n\nModule modMain\n\n    Sub Main()\n        ' Read the startup flag from App.config\n        Dim showLoginFirst As Boolean = _\n            Convert.ToBoolean(ConfigurationSettings.AppSettings("ShowLoginWindow"))\n\n        If showLoginFirst Then\n            Application.Run(New LoginForm)\n        Else\n            Application.Run(New SplashScreenForm)\n            ' Assuming after showing the splash screen, you start your main app logic here\n            ' For example:\n            ' MainForm.Show()\n        End If\n    End Sub\n\nEnd Module