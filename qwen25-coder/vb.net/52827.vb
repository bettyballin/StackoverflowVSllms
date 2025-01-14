Private Sub FillWithTime(ByVal TripNum As String, ByRef travelReader As SqlDataReader, ByRef TimeData() As Object, ByRef Cell As System.Web.UI.WebControls.TableCell)\n    lblTrip.Text = TripNum\n    \n    ' Use parameterized query to avoid SQL injection\n    travelQuery.CommandText = "SELECT [StartLoc], [EndLoc],[TravelTime], [AvgSpeed], [Distance] FROM [TravelTimes] WHERE [TripNum] = @TripNum"\n    Dim tripParam As New SqlParameter("@TripNum", TripNum)\n    travelQuery.Parameters.Add(tripParam)\n\n    Using travelConnection\n        travelConnection.Open()\n        travelReader = travelQuery.ExecuteReader()\n\n        If travelReader.Read() Then\n            travelReader.GetValues(TimeData)\n\n            Cell.Text += "From: " + TimeData(0).ToString().Substring(9) + "<br />"\n            Cell.Text += "To: " + TimeData(1).ToString().Substring(9) + "<br />"\n            Cell.Text += "Travel Time: " + TimeData(2).ToString() + " minutes <br />"\n            Cell.Text += "Average Speed: " + TimeData(3).ToString() + " MPH <br />"\n            Cell.Text += "Distance: " + TimeData(4).ToString() + " miles <br />"\n        Else\n            Cell.Text += "No matching trip found for TripNum: " & TripNum\n        End If\n\n        travelReader.Close()\n    End Using\nEnd Sub