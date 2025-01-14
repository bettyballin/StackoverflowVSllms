Dim ControlType As Type = System.Reflection.Assembly.GetAssembly( _\n                          GetType(MyAssembly.MyControl)) _\n                         .GetType("MyAssembly.MyUnexposedControl")\n\nDim Matches As List(Of Control) = MyBaseControl.Controls.Cast(Of Control)() _\n                                    .Where(Function(c) c.GetType().IsAssignableFrom(ControlType) OrElse c.GetType().Equals(ControlType)) _\n                                    .ToList()