package com.example.liu.activiti7;

import java.io.Serializable;

/**
 * @Author: Liu Zelin
 * @Email: liuzelin@geek-zoo.coom
 * @Date: Create in 2022/4/21 8:00 PM
 */
public class UEL_POJO implements Serializable {

    //不能大小写混排
    //必须实现序列化
    private String zhixingren;
    private String pay;

    public String getZhixingren() {
        return zhixingren;
    }

    public void setZhixingren(String zhixingren) {
        this.zhixingren = zhixingren;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
