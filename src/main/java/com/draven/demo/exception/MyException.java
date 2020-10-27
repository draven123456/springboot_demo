
/**  
 * Filename:    MyException.java  
 * Description:   
 * Copyright:   Copyright (c) 2016 All Rights Reserved.
 * Company:     浙江物产电子商务有限公司
 * @author:     刘佳豪
 * @version:    1.0  
 * Create at:   2018-4-27 上午9:12:11  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2018-4-27      刘佳豪   1.0         1.0 Version  
 *
*/  

package com.draven.demo.exception;

/**
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2018-4-27      刘佳豪      1.0         1.0 Version  
 *
*/
public class MyException extends Exception{
    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg ;
    
    /**
     * 
     */
    public MyException(String code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
