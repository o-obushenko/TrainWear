package com.oless.trainwear.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by oless on 10/17/15.
 */
public class UrlUtils {

    public static String generateParamString(HashMap<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (String key : params.keySet())
        {
            Object value = params.get(key);
            if (value != null)
            {
                try
                {
                    value = URLEncoder.encode(String.valueOf(value), "UTF-8");


                    if (builder.length() > 0)
                        builder.append("&");
                    builder.append(key).append("=").append(value);
                }
                catch (UnsupportedEncodingException e)
                {
                    return "";
                }
            }
        }
        return builder.toString();
    }
}
