$facebook->api_client->profile_setFBML(\n    NULL,       // FBML markup for the regular profile box (if any)\n    128009,     // User ID (replace with actual user ID you want to target)\n    'profile',  // The type of profile view ('profile' or 'canvas')\n    NULL,       // TBML markup for the mobile version of the profile box\n    'mobile_profile',\n    'profile_main'\n);