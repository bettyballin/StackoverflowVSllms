$offer1calcsavingsann = round($offer1calcsavings * 12);\n$offer2calcsavingsann = round($offer2calcsavings * 12);\n$offer3calcsavingsann = round($offer3calcsavings * 12);\n$offer4calcsavingsann = round($offer4calcsavings * 12);\n$offer5calcsavingsann = round($offer5calcsavings * 12);\n$offer6calcsavingsann = round($offer6calcsavings * 12);\n$offer7calcsavingsann = round($offer7calcsavings * 12);\n\n// ...\n\necho '<tr >\n     <td >\n <a href="'.$offerlink.'" target="blank"><img src="http://www.nextadvisor.com'.$offerlogo.'" alt="'.$offername.'" />\n </a>\n </td>\n<td ><span class="rating_text">Rating:</span>\n <span class="star_rating1">\n <img src="http://www.nextadvisor.com'.$offerstar.'" alt="" />\n </span>\n <br />\n  <div style="margin-top:5px; color:#0000FF;">\n <a href="'.$offerlink.'" target="blank">Go to Site</a>\n <span style="margin:0px 7px 0px 7px;">|</span><a href="'.$offeranchor.'">Review</a>     \n\n </div> </td>\n       <td >$'.$offerprice.'</td>\n     <td >$'.number_format($offercalcsavingsann).'</td>\n\n\n   </tr>';