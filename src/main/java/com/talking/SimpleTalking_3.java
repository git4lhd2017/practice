package com.talking;
import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.*;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.Main;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @program: basicDemo
 * @description: 图形化加快捷键调用
 * @author: 无能狂怒
 * @create: 2020-05-27 11:24
 **/
public class SimpleTalking_3 extends JFrame implements ActionListener {



        public JButton jb1, jb2, jb3, jb4, jb5, jb6;
        // 快捷键1,2,3个
        public static final int GLOBAL_HOT_KEY_1 = 0;
        public static final int GLOBAL_HOT_KEY_2 = 1;
        public static final int GLOBAL_HOT_KEY_3 = 2;

        // 初始化
        public SimpleTalking_3() {
            init();
        }

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SimpleTalking_3();
                }
            });
        }

        // 初始化
        private void init() {
            JPanel jp1 = new JPanel();
            jp1.setLayout(null);
            jb1 = new JButton("测试(F10)");
            jb1.setBounds(20, 20, 260, 30);
            jb1.addActionListener(this);
            jp1.add(jb1);

            jb2 = new JButton("祖安土著(Shift+F10)");
            jb2.setBounds(20, 60, 260, 30);
            jb2.addActionListener(this);
            jp1.add(jb2);

            jb3 = new JButton("祖安狂人-所有人(Shift+Ctrl+F10)");
            jb3.setBounds(20, 100, 260, 30);
            jb3.addActionListener(this);
            jp1.add(jb3);

            jb4 = new JButton("取消(F10)");
            jb4.setBounds(20, 140, 260, 30);
            jb4.addActionListener(this);
            jp1.add(jb4);

            jb5 = new JButton("取消(Shift+F10)");
            jb5.setBounds(20, 180, 260, 30);
            jb5.addActionListener(this);
            jp1.add(jb5);

            jb6 = new JButton("取消(Shift+Ctrl+F10)");
            jb6.setBounds(20, 220, 260, 30);
            jb6.addActionListener(this);
            jp1.add(jb6);

            QQBoom boom=new QQBoom();
            // 添加热键监听器
            // 第二步：添加热键监听器
            JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
                public void onHotKey(int markCode) {
                    switch (markCode) {
                        case GLOBAL_HOT_KEY_1:
                            boom.boomtest1(1);
                            break;
                        case GLOBAL_HOT_KEY_2:
                            boom.boomtest1(2);
                            break;
                        case GLOBAL_HOT_KEY_3:
                            boom.boomtest1(3);
                            break;
                    }
                }
            });

            this.add(jp1);
            this.setTitle("启用快捷键");
            this.setSize(310, 310);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        // 事件监听
        @Override
        public void actionPerformed(ActionEvent e) {
            // 监听注册全局快捷键
            if (e.getSource().equals(jb1)) {
                // 第一步：注册热键，热键标识，组合键（shift），主要热键F10
                JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_1, 0, 121);
                JOptionPane.showMessageDialog(null, "测试(F10)", "启用成功", JOptionPane.WARNING_MESSAGE);
            }
            // 监听注册全局快捷键
            if (e.getSource().equals(jb2)) {
                JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_2, JIntellitype.MOD_SHIFT, 121);
                JOptionPane.showMessageDialog(null, "祖安土著(Shift+F10)", "启用成功", JOptionPane.WARNING_MESSAGE);
            }
            // 监听注册全局快捷键
            if (e.getSource().equals(jb3)) {
                JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_3,
                        JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, 121);
                JOptionPane.showMessageDialog(null, "祖安狂人(Shift+Ctrl+F10)", "启用成功", JOptionPane.WARNING_MESSAGE);
            }
            // 监听删除全局快捷键
            if (e.getSource().equals(jb4)) {
                JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_1);
                JOptionPane.showMessageDialog(null, "取消(F10)", "取消成功", JOptionPane.WARNING_MESSAGE);
            }
            // 监听删除全局快捷键
            if (e.getSource().equals(jb5)) {
                JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_2);
                JOptionPane.showMessageDialog(null, "取消(Shift+F10)", "取消成功", JOptionPane.WARNING_MESSAGE);
            }
            // 监听删除全局快捷键
            if (e.getSource().equals(jb6)) {
                JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_3);
                JOptionPane.showMessageDialog(null, "取消(Shift+Ctrl+F10)", "取消成功", JOptionPane.WARNING_MESSAGE);
            }
        }
    }


    class QQBoom {


    static String greetings = null;

    public QQBoom(){
        File txt = new File("D://greetings.txt");
        if(!txt.exists()) {
            try {
                txt.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "错误", "读文件错误，请手动在D盘下创建greetings.txt文件并填充语句！", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        }

        try {
            BufferedReader  br = new BufferedReader(new InputStreamReader(new FileInputStream(txt),"gbk"));
            greetings = br.readLine();
            System.out.println(greetings);
            br.close();
        } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "错误", "读流操作失败！", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "错误", "关流操作失败！", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }


    /** 
    * @Description: 发送功能
    * @Param: [search] 1，默认开始。2，本方队友。3，所有人攻击。
    * @return: void 
    * @Author: 无能狂怒 
    * @Date: 2020/5/27 
    */
    public static void boomtest1(int search){
        boolean all = false;//是否开启所有人
        String sentence=null;//发送语句
        int num=0;
        if(search==1) {
            sentence = "测试功能";// 定义F10要发送的话
            num=1;//发送的次数
        }
        else if(search==2) {
            sentence = greetings;// 定义Shift+F10要发送的话
            num=1;//发送的次数
        }
        else {
            all = true;
            sentence = greetings;// 定义Shift+Ctrl+F10要发送的话
            num=1;//发送的次数
        }
        Robot robot=null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 创建Robot对象
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String[] authors = sentence.split("[,|，]");// 字符串根据,分割
        robot.delay(5000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒

        for (int j = 0; j < num; j++) {//TODO 循环次数，默认一次，留作以后更改
            for (int i = 0; i < authors.length; i++) {
                String sentencet = authors[i];
                Transferable tText = new StringSelection(sentencet);
                clip.setContents(tText, null);
                if (all){
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_ENTER);// 打开所有人
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }else{
                    robot.keyPress(KeyEvent.VK_ENTER);// 不开所有人
                }

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);// 释放按键
                robot.delay(300);// 延迟0.1秒再发送，
                robot.keyPress(KeyEvent.VK_ENTER);// 回车
                // }
            }
        }
    }
}