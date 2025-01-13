<?php\n  // PayPal PDT settings\n  $paypal_url = 'https://www.paypal.com/cgi-bin/webscr';\n  $paypal_email = 'your_email@example.com';\n  $paypal_return_url = 'http://example.com/return.php';\n  $paypal_cancel_url = 'http://example.com/cancel.php';\n\n  // User data\n  $user_id = 123;\n  $membership_plan = 'gold';\n  $expiration_date = date('Y-m-d', strtotime('+3 months'));\n\n  // PayPal payment data\n  $payment_amount = 19.99;\n  $payment_currency = 'USD';\n\n  // Create PayPal payment form\n  $paypal_form = '<form action="' . $paypal_url . '" method="post">';\n  $paypal_form .= '<input type="hidden" name="cmd" value="_xclick">';\n  $paypal_form .= '<input type="hidden" name="business" value="' . $paypal_email . '">';\n  $paypal_form .= '<input type="hidden" name="item_name" value="Membership Upgrade">';\n  $paypal_form .= '<input type="hidden" name="amount" value="' . $payment_amount . '">';\n  $paypal_form .= '<input type="hidden" name="currency_code" value="' . $payment_currency . '">';\n  $paypal_form .= '<input type="hidden" name="return" value="' . $paypal_return_url . '">';\n  $paypal_form .= '<input type="hidden" name="cancel_return" value="' . $paypal_cancel_url . '">';\n  $paypal_form .= '<input type="submit" value="Pay with PayPal">';\n  $paypal_form .= '</form>';\n\n  // Display PayPal payment form\n  echo $paypal_form;\n?>