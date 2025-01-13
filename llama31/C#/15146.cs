public partial class Window1 : Window\n{\n  public Window1()\n  {\n    InitializeComponent();\n  }\n\n  protected override void OnMouseMove(MouseEventArgs e)\n  {\n    base.OnMouseMove(e);\n    mask.Opacity = 0.5;\n    mask.Margin = new Thickness(e.GetPosition(this).X, e.GetPosition(this).Y, 0, 0);\n    LinearGradientBrush opacityMask = (LinearGradientBrush)((Image)Content).OpacityMask;\n    opacityMask.GradientStops[1].Offset = e.GetPosition(this).X / ActualWidth;\n  }\n}