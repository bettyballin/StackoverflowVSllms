<!-- app/views/products/show.html.erb -->\n<%= form_for @product, url: rate_product_path(@product), remote: true do |f| %>\n  <div class="rating">\n    <input type="hidden" name="score" id="product_score"/>\n  </div>\n<% end %>\n\n<script>\n$(document).ready(function() {\n  $('.rating').starRating({\n    starSize: 25,\n    callback: function(currentRating, $el){\n      $('#product_score').val(currentRating);\n      $.ajax({\n        url: '<%= rate_product_path(@product) %>',\n        type: 'post',\n        data: { score: currentRating },\n        dataType: 'json'\n      });\n    }\n  });\n});\n</script>