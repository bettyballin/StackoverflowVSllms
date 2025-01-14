Imports System.Xml.Linq\n\nModule Module1\n    Sub Main()\n        Dim xmlString As String = "<NewDataSet>..." ' Insert your XML string here or load from file.\n        \n        ' Parse the XDocument.\n        Dim xmlDoc As XDocument = XDocument.Parse(xmlString)\n        \n        ' Define a list to hold the final data objects.\n        Dim dataList As New List(Of ASNData)\n\n        ' Querying for each NewDataTable in the XML.\n        For Each dataTable In xmlDoc.<NewDataSet>.<NewDataTable>\n            ' Populate the DataClass properties.\n            Dim data As New ASNData With {\n                .Field = dataTable.<Field>.Value,\n                .Value = dataTable.<Val>.Value\n            }\n            \n            ' Process order elements within each NewDataTable.\n            data.Orders = (From order In dataTable.<Order>\n                           Select New ASNData.Order With {\n                               .Number = order.Attribute("Number").Value,\n                               .ShippingDate = DateTime.Parse(order.Attribute("ShipDate").Value)\n                           }).ToList()\n            \n            ' Add DataClass object to the list.\n            dataList.Add(data)\n        Next\n        \n        ' Output some data for confirmation\n        For Each item In dataList\n            Console.WriteLine($"Field: {item.Field}, Value: {item.Value}")\n            For Each order In item.Orders\n                Console.WriteLine($"  Order Number: {order.Number}, ShipDate: {order.ShippingDate.ToShortDateString()}")\n            Next\n        Next\n        \n    End Sub\nEnd Module\n\nPublic Class ASNData\n    Private _field As String\n    Private _value As String\n    Private _orders As List(Of Order)\n\n    Public Property Field() As String\n        Get\n            Return _field\n        End Get\n        Set(value As String)\n            _field = Value\n        End Set\n    End Property\n\n    Public Property Value() As String\n        Get\n            Return _value\n        End Get\n        Set(value As String)\n            _value = value\n        End Set\n    End Property\n\n    Public Property Orders() As List(Of Order)\n        Get\n            Return _orders\n        End Get\n        Set(value As List(Of Order))\n            _orders = Value\n        End Set\n    End Property\n\n    Structure Order\n        Private _number As String\n        Private _date As DateTime\n\n        Public Property Number() As String\n            Get\n                Return _number\n            End Get\n            Set(value As String)\n                _number = value\n            End Set\n        End Property\n\n        Public Property ShippingDate() As DateTime\n            Get\n                Return _date\n            End Get\n            Set(value As DateTime)\n                _date = Value\n            End Set\n        End Property\n    End Structure\nEnd Class