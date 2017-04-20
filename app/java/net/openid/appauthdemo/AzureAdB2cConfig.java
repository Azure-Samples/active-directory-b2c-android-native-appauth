package net.openid.appauthdemo;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

class AzureAdB2cConfig {

    private final Resources res;

    AzureAdB2cConfig(Context context) {
        res = context.getResources();
    }

    private String getTenant(){
        return res.getString(R.string.tenant);
    }

    private String getBaseUrl(){
        return res.getString(R.string.base_url);
    }

    private String getPolicySignUpSignIn(){
        return res.getString(R.string.policy_signupsignin);
    }
    private String getPolicyEditProfile(){
        return res.getString(R.string.policy_edit_profile);
    }

    String getClientId(){
        return res.getString(R.string.client_id);
    }

    Uri getRedirectUri(){
        return Uri.parse(res.getString(R.string.redirect_uri));
    }

    private String getApiUri() {
        return res.getString(R.string.api_url);
    }

    private String[] getApiScopes() {
        return res.getString(R.string.api_scopes).split(" ");
    }

    private boolean hasApi() {
        return !getApiUri().isEmpty() && getApiScopes().length > 0;
    }

    String getResponseType(){
        return "id_token" + (hasApi() ? " code" : "");
    }

    String getScope(){
        String finalScope = "openid";
        if (hasApi()) {
            finalScope += " offline_access";
            String apiUri = getApiUri();
            for (String scope : getApiScopes()) {
                finalScope += " " + apiUri + "/" + scope;
            }
        }
        return finalScope;
    }

    Uri getDiscoveryEndpoint(){
        return Uri.parse(
                String.format(getBaseUrl() + "/.well-known/openid-configuration",
                        getTenant(), getPolicySignUpSignIn()));
    }
}
