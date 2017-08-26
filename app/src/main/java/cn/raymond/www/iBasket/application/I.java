package cn.raymond.www.iBasket.application;

/**
 * Created by scorpion on 2017/8/25.
 * 存放跟接口有关的参数
 *
 */

public interface I {

    String SERVER_ROOT = "http://101.251.196.90:8080/FuLiCenterServerV2.0/";

    /** 第一次进入界面，进行下载*/
    int ACTION_DOWNLOAD = 0;
    /** 上拉刷新*/
    int ACTION_PULL_UP = 1;
    /** 下拉刷新*/
    int ACTION_PULL_DOWN = 2;

    /** 每行显示的数量columNum*/
    int COLUM_NUM = 2;

    /** 表示列表项布局的两种类型*/
    int TYPE_ITEM=0;
    int TYPE_FOOTER=1;
}
