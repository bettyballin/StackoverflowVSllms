using System.Windows;\nusing System.Windows.Controls;\nusing System.Windows.Media;\nusing System.Windows.Media.Animation;\n\npublic partial class MainWindow : Window\n{\n    public MainWindow()\n    {\n        InitializeComponent();\n\n        // Order info\n        Canvas order_info = new Canvas();\n        order_info.Width = 220;\n        order_info.Height = 250;\n        order_info.Background = Brushes.Yellow;\n\n        // Adding some text to the canvas for demonstration\n        TextBlock textBlock = new TextBlock { Text = "Sample Text", FontSize = 16 };\n        Canvas.SetLeft(textBlock, 50);\n        Canvas.SetTop(textBlock, 110);\n        order_info.Children.Add(textBlock);\n\n        user_info.Children.Add(order_info);\n\n        // Order info mask\n        Rectangle order_info_mask = new Rectangle();\n        order_info_mask.Width = 110;\n        order_info_mask.Height = 250;\n        order_info_mask.Fill = Brushes.Black;\n\n        user_info.Children.Add(order_info_mask);\n\n        // Apply mask\n        VisualBrush mask_brush = new VisualBrush();\n        mask_brush.Visual = order_info_mask;\n        order_info.OpacityMask = mask_brush;\n\n        // Animation to change the scale of the mask\n        ScaleTransform transform = new ScaleTransform { ScaleX = 1, ScaleY = 1 };\n        order_info_mask.RenderTransform = transform;\n        order_info_mask.RenderTransformOrigin = new Point(0.5, 0.5);\n\n        DoubleAnimation scaleXAnim = new DoubleAnimation\n        {\n            From = 1,\n            To = 0.2,\n            AutoReverse = true,\n            RepeatBehavior = RepeatBehavior.Forever\n        };\n\n        DoubleAnimation scaleYAnim = new DoubleAnimation\n        {\n            From = 1,\n            To = 2,\n            AutoReverse = true,\n            RepeatBehavior = RepeatBehavior.Forever\n        };\n\n        transform.BeginAnimation(ScaleTransform.ScaleXProperty, scaleXAnim);\n        transform.BeginAnimation(ScaleTransform.ScaleYProperty, scaleYAnim);\n\n        // Animation to move the mask\n        DoubleAnimation translateXAnim = new DoubleAnimation\n        {\n            From = 0,\n            To = 220,\n            AutoReverse = true,\n            RepeatBehavior = RepeatBehavior.Forever\n        };\n\n        TranslateTransform transltform = new TranslateTransform();\n        order_info_mask.RenderTransform = new TransformGroup\n        {\n            Children = { transform, transltform }\n        };\n\n        transltform.BeginAnimation(TranslateTransform.XProperty, translateXAnim);\n    }\n}