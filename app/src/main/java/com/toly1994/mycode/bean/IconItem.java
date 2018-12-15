package com.toly1994.mycode.bean;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:9:37<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class IconItem {
    private int color;
    private int iconId;
    private String info;

    public IconItem(String info, int iconId, int color) {
        this.color = color;
        this.iconId = iconId;
        this.info = info;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
