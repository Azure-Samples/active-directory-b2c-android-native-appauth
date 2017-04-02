---
services: active-directory-b2c
platforms: android
author: parakhj
---

# Integrate Azure AD B2C into an Android application

**This sample demonstrates how to use Azure AD B2C using a 3rd party library called AppAuth. It has only been tested for compatibility in basic scenarios with Azure AD B2C. Issues and feature requests should be directed to the library's open-source project.**

This sample is a quickstart to help you get started with Azure AD B2C on Android using a 3rd party library called AppAuth. The sample is already configured to use a demo environment and can be run simply by downloading the code and building the app on your machine. Follow the instructions below if you would like to use your own Azure AD B2C configuration.

This sample was adapted from the [original Android AppAuth sample](https://github.com/openid/AppAuth-Android). For more details on how the sample and the library work, please look at the original sample.

## Steps to Run

To use Azure AD B2C, you'll first need to create an Azure AD B2C tenant, register your application, and create some sign in and sign up experiences.

* To create an Azure AD B2C tenant, checkout [these steps](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-get-started).

* To register your app, checkout [these steps](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-app-registration).  Make sure the "Native Client" switch is turned to "Yes". You will need to supply a Redirect URL with a custom scheme in order for your Android application to capture the callback. To avoid a collision with another application, we recommend using an unique scheme. The example redirect URI in this sample is: "com.onmicrosoft.fabrikamb2c.exampleapp:/oauth/redirect". We recommend replacing fabrikamb2c with your tenant name, and exampleapp with the name of your application.

* Define your [custom sign in and sign up experience](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-reference-policies).  In Azure AD B2C, you define the experience your end users will encounter by creating policies.  For this sample, you'll want to create a single combined Sign In/Sign up policy.

* Clone the code: 

   ```git clone https://github.com/Azure-Samples/active-directory-android-native-appauth-b2c.git```

### Setting up the Android App

1. In Android Studio, click on "File"->"New"->"Import Project" and select the cloned folder. You will likely get a few errors and need to install some additional tools in Android Studio. Follow the prompts and let Android Studio update the local data.

    **The app is already preconfigured to a demo Azure B2C tenant. At this point, you should be able to build and run the app. Follow the instructions below to configure the app with your own tenant information.**

2. Inside `/app/res/values/idp_configs.xml`, replace the following fields:

   * `b2c_tenant`: This is the name of your Azure AD B2C tenant
   * `b2c_client_id`: This is your Application ID, which can be found in the Azure Portal (under Application settings).
   * `b2c_redirect_uri`: This is your redirect URI, which can be found in the Azure Portal (under Application settings).
   * `b2c_signupin_policy`: This is the name of your Sign Up or Sign In policy.

3. Inside '/app/build.gradle', replace the value for `appAuthRedirectScheme`. This should correspond to the scheme of the `b2c_redirect_uri`.

4. Go ahead and try the app.  You'll be able to see your custom experience, sign up for an account, and sign in to an existing account. Upon completing the login process, you should see the types of tokens acquired.


## Next Steps

Customize your user experience further by supporting more identity providers.  Checkout the docs belows to learn how to add additional providers:

[Microsoft](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-setup-msa-app)

[Facebook](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-setup-fb-app)

[Google](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-setup-goog-app)

[Amazon](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-setup-amzn-app)

[LinkedIn](https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-setup-li-app)


## Questions & Issues

Please file any questions or problems with the sample as a github issue. You can also post on [StackOverflow](https://stackoverflow.com/questions/tagged/azure-ad-b2c) with the tag `azure-ad-b2c`.

This sample was built and tested with the Android Virtual Device Manager on versions 23-24 using Android Studio 2.2.3.

## Acknowledgements

This sample was adapted from the [Android AppAuth sample](https://github.com/openid/AppAuth-Android).

