/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package org.xhubacubi.jarhalla.client.util;

/**
 *
 * @author rugi
 */
public class StringUtil {

    /**
     * 
     * @param input
     * @return 
     */
    public static String generatePattern(String input) {
        StringBuilder res = new StringBuilder();
        if (!input.startsWith("*")) {
            res.append("(.*?)");
        }
        res.append(input.replaceAll("\\*", "(.*?)"));
        if (!input.endsWith("*")) {
            res.append("(.*?)");
        }
        return res.toString();
    }
}
