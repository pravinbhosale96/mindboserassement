Execution Steps
1 - Set db properties in application.properties file.
2 - Set Stripes API access key - STRIPE_PUBLIC_KEY, STRIPE_SECRET_KEY.

3 - Create New manger record using http://localhost:8083/manager/create api.
4 - use the email and password for getting access token using http://localhost:8083/oauth/token api.
           Client id - pravin-client
           Client secret - pravin-secret
         I am using oauths POST and DELETE api as login logout functinality.
5 - After getting accesstoken use it for payment processses
       1 - Checkout final amount using  http://localhost:8083/api/checkout.
       2 - Charge amount using http://localhost:8083/api/charge

