render :update do |page|\n  page.replace_html "chart-div", "<img src=\"/charts/#{chart.chart_file}\"/>" \nend