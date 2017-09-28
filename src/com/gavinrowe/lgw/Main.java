package com.gavinrowe.lgw;

/**
 * Author: 罗国文
 * Email: luoguowen123@qq.com
 * Time: 2017-09-28 10:28:17
 * Version:1.0
 * 简单单词转换 程序入口
 * 将小驼峰或者大驼峰命名转换为用于常量的以'_'分割的全大写命名
 *
 * 小驼峰命名法：除第一个单词之外，其他单词首字母大写，如：doSomeThing
 * 大驼峰命名法：第一个单词大写，其它同上，如：DoSomeThing
 * 常量命名法：所有字母大写，每个词之间用_分割，如：MAX_VALUE
 */
public class Main {

    public static void main(String[] args) {
        new Home();
    }
}
