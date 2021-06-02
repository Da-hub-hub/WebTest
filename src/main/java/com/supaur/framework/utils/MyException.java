package com.supaur.framework.utils;

public class MyException extends Exception{
    private static final long serialVersionUID = 1L;

    // 提供无参数的构造方法
    public MyException() {
    }

    // 提供一个有参数的构造方法，可自动生成
    public MyException(String message) {
        super(message);// 把参数传递给Throwable的带String参数的构造方法
    }
    public MyException(String mesage,Throwable cause){
        super(mesage,cause);
    }
    public MyException(Throwable cause){
        super(cause);
    }
    //重写该方法后，会只打印第一条信息，节省日志空间，方便查看，更可以提高部分性能
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }


}
