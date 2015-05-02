/*
 The MIT License (MIT)

 Copyright (c) 2015 Aleksandar Cvetković

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package htsquirrel.oauth;

import static htsquirrel.oauth.OAuthKeys.getConsumerKey;
import static htsquirrel.oauth.OAuthKeys.getConsumerSecret;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class OAuth {
    
    public static OAuthService getOAuthService() {
        OAuthService oAuthService;
        oAuthService = new ServiceBuilder().provider(HattrickApi.class)
                .apiKey(getConsumerKey())
                .apiSecret(getConsumerSecret())
                .build();
        return oAuthService;
    }
    
    public static Token getRequestToken(OAuthService oAuthService) {
        Token requestToken = oAuthService.getRequestToken();
        return requestToken;
    }
    
    public static Verifier getVerifier(String verificationCode) {
        Verifier verifier = new Verifier(verificationCode);
        return verifier;
    }
    
    public static String getResponse(OAuthService oAuthService,
            Token accessToken, String parameters) {
        OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET,
                "http://chpp.hattrick.org/chppxml.ashx?file=" + parameters);
        oAuthService.signRequest(accessToken, oAuthRequest);
        Response response = oAuthRequest.send();
        return response.getBody();
    }
    
}
