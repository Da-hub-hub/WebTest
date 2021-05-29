
package com.supaur.framework.Sprint1.baseEntity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author z0228
 */
@SuppressWarnings({"WeakerAccess", "unchecked", "unused"})
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
public class Response2<T> implements Serializable {
    public static final String GENERAL_SUCCESS_CODE = "maskit.success.general";
    public static final String GENERAL_SUCCESS_MESSAGE = "Maskit general success";
    public static final String GENERAL_FAILURE_CODE = "maskit.failure.general";
    public static final String GENERAL_FAILURE_MESSAGE = "Maskit general failure";
    public static final int GENERAL_SUCCESS_STATUS = 200;
    public static final int GENERAL_FAILURE_STATUS = 400;

    @Getter
    @Setter
    private int status = GENERAL_SUCCESS_STATUS;
    @Getter
    @Setter
    private String error = GENERAL_SUCCESS_CODE;
    @JsonIgnore
    private Object[] args = null;
    @Getter
    @Setter
    private String message = GENERAL_SUCCESS_MESSAGE;
    @Getter
    @Setter
    private Date timestamp = null;
    @Getter
    @Setter
    private T data = null;
    @Getter
    @Setter
    private String path = null;

    public Response2(int status, String error, String message, T data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean success() {
        return status == 200 || status > 200 && status < 300;
    }

    public static <T> Response2<T> yes() {
        return new Response2(GENERAL_SUCCESS_STATUS, GENERAL_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, true);
    }

    public static <T> Response2<T> yes(final T data) {
        return new Response2(GENERAL_SUCCESS_STATUS, GENERAL_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, data);
    }

    public static <T> Response2<T> yes(final T data, final String code) {
        return new Response2(GENERAL_SUCCESS_STATUS, code, GENERAL_SUCCESS_MESSAGE, data);
    }

    public static <T> Response2<T> yes(final T data, final int status) {
        return new Response2(status, GENERAL_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, data);
    }

    public static <T> Response2<T> yes(final T data, final int status, final String code) {
        return new Response2(status, code, GENERAL_SUCCESS_MESSAGE, data);
    }

    public static <T> Response2<T> yes(final T data, final int status, final String code, final String message) {
        return new Response2(status, code, message, data);
    }

    public static <T> Response2<T> no() {
        return new Response2(GENERAL_FAILURE_STATUS, GENERAL_FAILURE_CODE, GENERAL_FAILURE_MESSAGE, null);
    }

    public static <T> Response2<T> no(final String code) {
        return new Response2(GENERAL_FAILURE_STATUS, code, GENERAL_FAILURE_MESSAGE, null);
    }

    public static <T> Response2<T> no(final int status) {
        return new Response2(status, GENERAL_FAILURE_CODE, GENERAL_FAILURE_MESSAGE, null);
    }

    public static <T> Response2<T> no(final int status, final String code) {
        return new Response2(status, code, GENERAL_FAILURE_MESSAGE, null);
    }

    public static <T> Response2<T> no(final int status, final String code, final String message) {
        return new Response2(status, code, message, null);
    }

    public static <T> Response2<T> no(final int status, final String code, final T data) {
        return new Response2(status, code, GENERAL_FAILURE_MESSAGE, data);
    }

    public static <T> Response2<T> no(final T data) {
        return new Response2<>(GENERAL_FAILURE_STATUS, GENERAL_FAILURE_CODE, GENERAL_FAILURE_MESSAGE, data);
    }

    public static <T> Response2<T> auto(final Boolean success, final String code, final T data) {
        return new Response2(success ? GENERAL_SUCCESS_STATUS : GENERAL_FAILURE_STATUS,
            code, success ? GENERAL_SUCCESS_MESSAGE : GENERAL_FAILURE_MESSAGE, data);
    }



    public void args(Object... args) {
        this.args = args;
    }

    public Object[] args() {
        return this.args;
    }
}

