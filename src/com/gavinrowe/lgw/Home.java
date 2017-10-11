package com.gavinrowe.lgw;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Author: Luo GuoWen
 * Email: luoguowen123@qq.com
 * Time: 2017/9/28
 * 主页
 */
class Home extends JDialog {
    /**
     * 分隔符
     */
    private static final char SEPARATOR = '_';

    /**
     * 本体宽高
     */
    private static final int WIDTH = 400, HEIGHT = 300;

    /**
     * 顶部面板宽高
     */
    private static final int TOP_PANEL_WIDTH = 400, TOP_PANEL_HEIGHT = 124;

    /**
     * 标签名
     * 转换前，转换后
     */
    private static final String LABEL_NAME_BEFORE_CHANGE = "转换前", LABEL_NAME_AFTER_CHANGE = "转换后";

    /**
     * 转换按钮名
     * 转换
     */
    private static final String BTN_NAME_CHANGE = "转换";

    /**
     * 信息对话框标题
     */
    private static final String INFO_DIALOG_TITLE = "温馨提示";

    /**
     * 警告信息
     */
    private static final String MSG_W_NOT_ENOUGH = "请至少包含两个单词！";

    /**
     * 标题
     */
    private static final String TITLE = "简单单词转换 V1.0 --By国哥";

    /**
     * 图标地址
     */
    private static final String IMG_URL = "images/cool.png";

    /**
     * 帮助
     */
    private static final String GUIDE = "将小驼峰或者大驼峰命名转换为用于常量的以'_'分割的全大写命名。\n" +
            "转换成功后会自动复制到粘贴板哦！\n" +
            "小驼峰命名法：除第一个单词之外，其他单词首字母大写，如：doSomeThing。\n" +
            "大驼峰命名法：第一个单词大写，其它同上，如：DoSomeThing。\n" +
            "常量命名法：所有字母大写，每个词之间用_分割，如：MAX_VALUE。";

    /**
     * 关于
     */
    private static final String ABOUT = "Author: 罗国文\n" +
            "Email: luoguowen123@qq.com\n" +
            "Time: 2017-09-28\n" +
            "Version:1.0";

    /**
     * 菜单标题，帮助
     */
    private static final String MENU_HELP = "帮助";
    /**
     * 菜单选项标题，关于
     */
    private static final String MENU_ITEM_ABOUT = "关于";
    /**
     * 菜单选项标题，使用说明
     */
    private static final String MENU_ITEM_GUIDE = "使用说明";

    /**
     * 声明按钮引用：JButton mChangeBtn 转换按钮
     */
    private JButton mChangeBtn = new JButton(BTN_NAME_CHANGE);

    /**
     * 声明面板引用：JPanel mTop 顶部面板, mMid 中部面板, mBot 底部面板
     */
    private JPanel mTop = new JPanel(), mMid = new JPanel(), mBot = new JPanel();

    /**
     * 声明标签引用：JLabel mBeforeChangeLabel 转换前, mAfterChangeLabel 转换后
     */
    private JLabel mBeforeChangeLabel = new JLabel(LABEL_NAME_BEFORE_CHANGE);
    private JLabel mAfterChangeLabel = new JLabel(LABEL_NAME_AFTER_CHANGE);

    /**
     * 声明文本框引用：JTextField mBeforeChangeField 转换前本框, mAfterChangeField 转换后文本框
     */
    private JTextField mBeforeChangeField = new JTextField(), mAfterChangeField = new JTextField();

    private JMenuBar mJMenuBar = new JMenuBar();

    // 首页构造，初始化内容
    Home() {
        initView();
    }

    private void initView() {
        // 设置面板
        setTop();
        setMid();
        setBot();
        setMenu();
        // 添加上、中、下三个面板
        add(mTop, BorderLayout.NORTH);
        add(mMid);
        add(mBot, BorderLayout.SOUTH);

        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        // 设置标题栏图标
        setIconImage(getImagePath(IMG_URL));
        // 设置默认出现在屏幕中央
        setLocationRelativeTo(null);
        // 添加窗口关闭事件
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // 设置是否可以更改大小：false
        setResizable(false);
        setJMenuBar(mJMenuBar);
        // 设置是否可见: true
        setVisible(true);
    }

    private void setMenu() {
        JMenu menuHelp = new JMenu(MENU_HELP);
        JMenuItem menuItemGuide = new JMenuItem(MENU_ITEM_GUIDE);
        JMenuItem menuItemAbout = new JMenuItem(MENU_ITEM_ABOUT);
        menuItemGuide.addActionListener(e -> showInfoDialog(MENU_ITEM_GUIDE, GUIDE));
        menuItemAbout.addActionListener(e -> showInfoDialog(MENU_ITEM_ABOUT, ABOUT));
        menuHelp.add(menuItemGuide);
        menuHelp.add(menuItemAbout);
        mJMenuBar.add(menuHelp);
    }

    /**
     * 显示信息对话框
     *
     * @param title   标题
     * @param content 内容
     */
    private void showInfoDialog(String title, String content) {
        JOptionPane.showMessageDialog(null, content, title, JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * 获取图片地址，用于读取Jar包里的图片
     *
     * @param resource 图片地址
     * @return Image对象
     */
    private Image getImagePath(String resource) {
        Image image = null;
        InputStream is = getClass().getClassLoader().getResourceAsStream(resource);
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 设置顶部面板
     */
    private void setTop() {
        // 添加标签
        mTop.add(new JLabel(new ImageIcon(getImagePath(IMG_URL))));
        // 设置尺寸
        mTop.setPreferredSize(new Dimension(TOP_PANEL_WIDTH, TOP_PANEL_HEIGHT));
    }

    /**
     * 设置中部面板
     */
    private void setMid() {
        setTextLabel(mBeforeChangeLabel, new Rectangle(10, 6, 100, 28));
        setTextLabel(mAfterChangeLabel, new Rectangle(10, 46, 100, 28));

        setTextField(mBeforeChangeField, new Rectangle(110, 6, 250, 34));
        setTextField(mAfterChangeField, new Rectangle(110, 46, 250, 34));

        // 添加转换前标签、文本框
        mMid.add(mBeforeChangeLabel);
        mMid.add(mBeforeChangeField);
        // 添加转换后标签、文本框
        mMid.add(mAfterChangeLabel);
        mMid.add(mAfterChangeField);
        mMid.setLayout(null);
    }


    /**
     * 初始化并设置文本标签
     *
     * @param label     标签
     * @param rectangle 位置和尺寸
     */
    private void setTextLabel(JLabel label, Rectangle rectangle) {
        // 设置位置、尺寸
        label.setBounds(rectangle);
        // 设置字体：黑体 粗体 28号
        label.setFont(new Font("黑体", Font.BOLD, 28));
    }

    /**
     * 初始化并设置文本框
     *
     * @param textField 文本框
     * @param rectangle 位置和尺寸
     */
    private void setTextField(JTextField textField, Rectangle rectangle) {
        // 设置位置、尺寸
        textField.setBounds(rectangle);
        // 设置内容字体
        textField.setFont(new Font("黑体", Font.PLAIN, 24));
    }

    /**
     * 设置底部面板
     */
    private void setBot() {
        setChangeBtn();
        // 添加转换按钮
        mBot.add(mChangeBtn);
        mBot.setPreferredSize(new Dimension(400, 56));
    }

    /**
     * 设置转换按钮
     */
    private void setChangeBtn() {
        mChangeBtn.addActionListener(e -> change());
        // 设置按钮大小
        mChangeBtn.setPreferredSize(new Dimension(70, 40));
        // 设置按钮字体
        mChangeBtn.setFont(new Font("宋体", Font.BOLD, 14));
    }

    /**
     * 转换
     */
    private void change() {
        String beforeChangeContent = mBeforeChangeField.getText();
        char[] chars = beforeChangeContent.toCharArray();

        if (2 > chars.length) {
            JOptionPane.showConfirmDialog(null, MSG_W_NOT_ENOUGH, INFO_DIALOG_TITLE, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            String result = changeResult(chars);
            ClipboardUtils.setClipboardContents(result);
            mAfterChangeField.setText(result);
        }

    }

    /**
     * 处理字符数组
     *
     * @param chars 字符数组
     * @return 返回处理后的结果
     */
    private String changeResult(char[] chars) {
        int len = chars.length;
        ArrayList<Character> characters = toList(chars);
        boolean isFirstChar = true;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (isUpper(chars[i])) {
                if (isFirstChar) {
                    characters.add(i, SEPARATOR);
                    isFirstChar = false;
                } else {
                    characters.add(i + count, SEPARATOR);
                    count++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character c : characters) {
            result.append(c);
        }

        return result.toString().toUpperCase();
    }

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private ArrayList<Character> toList(char[] chars) {
        ArrayList<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return characters;
    }
}
