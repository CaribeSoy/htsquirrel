/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Aleksandar Cvetković
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package htsquirrel;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;
import org.scribe.model.Verb;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class HattrickApi extends DefaultApi10a {

    @Override
    public String getRequestTokenEndpoint() {
        return "https://chpp.hattrick.org/oauth/request_token.ashx";
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://chpp.hattrick.org/oauth/access_token.ashx";
    }

    @Override
    public String getAuthorizationUrl(Token token) {
        return String.format("https://chpp.hattrick.org/oauth/authorize.aspx" +
                "?oauth_token=%s", token.getToken());
    }

    @Override
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

}
