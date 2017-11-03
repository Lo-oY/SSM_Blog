package com.ly.util;

import com.ly.pojo.Post;

/**
 * Created by cilu on 2017/11/1.
 */
public class PageUtils {

    public static String getPreAndNext(Post prePost, Post nextPost, String context) {
        StringBuffer sb = new StringBuffer();
        if (prePost == null) {
            sb.append("<p>上一篇:无<p>");
        } else {
            sb.append("<p>上一篇:<a href='" + context + "post/" + prePost.getId() + "'>" + prePost.getTitle() + "</a></P>");
        }
        if (nextPost == null) {
            sb.append("<p>下一篇:无<p>");
        } else {
            sb.append("<p>下一篇:<a href='" + context + "post/" + nextPost.getId() + "'>" + nextPost.getTitle() + "</a></P>");
        }
        return sb.toString();
    }
}
