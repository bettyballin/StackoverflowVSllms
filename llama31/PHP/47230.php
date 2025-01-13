<?php\n  $paypal_email = 'your_paypal_email@example.com';\n  $donation_amount = '5.00'; // default donation amount\n  $currency_code = 'USD'; // currency code\n  $return_url = 'https://example.com/thank-you'; // return URL after donation\n  $cancel_url = 'https://example.com/cancel'; // cancel URL\n\n  $form_action = 'https://www.paypal.com/cgi-bin/webscr';\n  $form_data = array(\n    'cmd' => '_donations',\n    'business' => $paypal_email,\n    'amount' => $donation_amount,\n    'currency_code' => $currency_code,\n    'return' => $return_url,\n    'cancel_return' => $cancel_url,\n  );\n\n  echo '<form action="' . $form_action . '" method="post">';\n  foreach ($form_data as $key => $value) {\n    echo '<input type="hidden" name="' . $key . '" value="' . $value . '">';\n  }\n  echo '<input type="submit" value="Donate Now">';\n  echo '</form>';\n?>