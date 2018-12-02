package com.bw.qgs.qgs2.comment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * date:2018/12/2    18:38
 * author:秦广帅(Lenovo)
 * fileName:CusTomComment
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CusTomComment {
    String userName();
    String passWord();
}
