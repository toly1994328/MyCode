package com.toly1994.mycode.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/13 0013:19:46<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class ResultBean {

    /**
     * code : 200
     * msg : 操作成功
     * data : [{"id":4,"type":"案例项目","name":"建站三部曲之后端接口篇（SpringBoot+上线）","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/0baa4b4b81f4","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/ba3080ca9ed155df90dc33cac0104dc6.png","createTime":"2018-12-11","info":"本系列分为三篇： 建站三部曲之后端接口篇（SpringBoot+上线） 建站三部曲之前端显示篇（React+上线） 建站三部曲之移动端篇（And...","area":"Re"},{"id":3,"type":"React","name":"React战记之玩转Flex布局(上篇--容器属性)","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/b4169b9ecf2e","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/ab1adf5570e3f9b8eb6c9fc637fb7838.png","createTime":"2018-12-09","info":"零、前言 最近一直在总结Android，前端这块感觉忘得也差不多了Flex布局以前也听过，但没有详细学习过，趁机会用React玩转一下，遇到一个...","area":"Re"},{"id":2,"type":"安卓资源","name":"Android资源res之矢量图完全指南（加SVG-path命令分析）","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/3691a8e00917","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/bae53dbfddd62617b5eeb68653f931b5.png","createTime":"2018-12-08","info":"零、前言 第一次接触SVG时，被它的强大折服，下面两个小例子可以看看SVG 文字sin型曲线动画、SVG绘制星空效果 Android5.0+也...","area":"A"},{"id":6,"type":"正则操作","name":"[番外]：带你玩正则1--数据遍地是,看你取不取","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/7a08cc91e674","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/260ac773c4bec0c5cc9968db40e07e32.png","createTime":"2018-12-07","info":"谨言：正则没有捷径,唯一法可破，多想，多用，再多想，再多用 最近想做个Android资源库:toly_res开源库，将一些常用字符串和res资源...","area":"A"},{"id":1,"type":"编程随笔","name":"随笔编程杂谈录--《隆中对》","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/5940bd3b6689","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/4b4e7e5f8b2a88cbc677a4776f6d9b05.png","createTime":"2018-12-06","info":"注：本篇非技术文，只是一些个人总结感触，不喜欢的出门左走 《隆中对》----张风捷特烈 是混乱还是进化 哪种语言好，哪种框架好 ------人好...","area":"Note"},{"id":5,"type":"原生View","name":"RecyclerView零点突破(动画+边线篇）","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/2812be64a6ae","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/3d326f758984199ab50f4d6442740547.png","createTime":"2018-12-05","info":"0、前言: 动画和边线估计有点冷门，很多人都将就凑合,今天我就来深入讲解一下吧边线的方案是网上流传的一种，个人感觉也是最好的，并稍稍改进了一点本...","area":"A"},{"id":10,"type":"原生View","name":"RecyclerView零点突破(基本使用篇）","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/ce04d1c65716","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/7ee0bafa34e15ad6df77f610db54a64b.png","createTime":"2018-12-04","info":"一直以为自己是会用RecyclerView的，但现在感觉只是刚入门而已本文以仿几个生活常见的界面来演示RecyclerView 本系列分为3篇：...","area":"A"},{"id":9,"type":"自定义控件","name":"Android自定义控件之数字显示","localPath":"null","jianshuUrl":"https://www.jianshu.com/p/dca7d5f8662a","juejinUrl":"null","imgUrl":"http://192.168.43.60:8089/imgs/android/9afbcbf212ca3d584256b132fcfea010.png","createTime":"2018-12-03","info":"需求 1.数字为1位,显示圆形2.数字为2位图形拉伸，左右各半圆3.数字大于999，显示999+4.自定义文字颜色，自定义背景色 效果(好吧，看...","area":"A"}]
     */

    private int code;
    private String msg;
    private List<NoteBean> data;

    public static ResultBean objectFromData(String str) {

        return new Gson().fromJson(str, ResultBean.class);
    }

    public static List<ResultBean> arrayResultBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ResultBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NoteBean> getData() {
        return data;
    }

    public void setData(List<NoteBean> data) {
        this.data = data;
    }

    public static class NoteBean {
        /**
         * id : 4
         * type : 案例项目
         * name : 建站三部曲之后端接口篇（SpringBoot+上线）
         * localPath : null
         * jianshuUrl : https://www.jianshu.com/p/0baa4b4b81f4
         * juejinUrl : null
         * imgUrl : http://192.168.43.60:8089/imgs/android/ba3080ca9ed155df90dc33cac0104dc6.png
         * createTime : 2018-12-11
         * info : 本系列分为三篇： 建站三部曲之后端接口篇（SpringBoot+上线） 建站三部曲之前端显示篇（React+上线） 建站三部曲之移动端篇（And...
         * area : Re
         */

        private int id;
        private String type;
        private String name;
        private String localPath;
        private String jianshuUrl;
        private String juejinUrl;
        private String imgUrl;
        private String createTime;
        private String info;
        private String area;

        public static NoteBean objectFromData(String str) {

            return new Gson().fromJson(str, NoteBean.class);
        }

        public static List<NoteBean> arrayNoteBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<NoteBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocalPath() {
            return localPath;
        }

        public void setLocalPath(String localPath) {
            this.localPath = localPath;
        }

        public String getJianshuUrl() {
            return jianshuUrl;
        }

        public void setJianshuUrl(String jianshuUrl) {
            this.jianshuUrl = jianshuUrl;
        }

        public String getJuejinUrl() {
            return juejinUrl;
        }

        public void setJuejinUrl(String juejinUrl) {
            this.juejinUrl = juejinUrl;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
