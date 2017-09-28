package com.gavinrowe.lgw;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Author: Luo GuoWen
 * Email: luoguowen123@qq.com
 * Time: 2017/9/28
 * 粘贴板工具类
 * 将内容复制到粘贴板
 */
public class ClipboardUtils {
    /**
     * 设置粘贴板内容
     *
     * @param content 内容
     */
    public static void setClipboardContents(String content) {
        StringSelection stringSelection = new StringSelection(content);
        // 系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
