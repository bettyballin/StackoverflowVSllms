gridSplitter.PreviewMouseLeftButtonDown += (s, e) => Panel.SetZIndex(gridSplitter, 2);\ngridSplitter.PreviewMouseLeftButtonUp += (s, e) => Panel.SetZIndex(gridSplitter, 1);