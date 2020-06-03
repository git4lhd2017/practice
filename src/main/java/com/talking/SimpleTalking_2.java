package com.talking;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
/**
 * @program: basicDemo
 * @description: 调用qq的聊天的刷屏
 * @author: 无能狂怒
 * @create: 2020-05-27 11:07
 **/
public class SimpleTalking_2 {


        public static void main(String[] args) throws Exception{
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    Robot robot = null;// 创建Robot对象
                    String url = "http://shang.qq.com/wpa/qunwpa?idkey=65c1684e948a6ebc407c5a248a2f1b8c748bb36c13e0fddf16ee61a6de69d98c";// 设置调用qq群聊天框url，idkey是QQ群推广地址，https://qun.qq.com/join.html这是查询链接
                    String cmd = "explorer \"" + url + "\"";// 通过cmd命令使用默认浏览器访问url
                    String[] a = new String[] { "E:\\1.jpg", "E:\\2.jpg", "E:\\3.jpg" };// 定义数组，放三个图片地址
                    robot.delay(5000);// 延迟五秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
                    for (int j = 0; j < 3; j++) {
                        Image image = new ImageIcon(a[j]).getImage();// 这里是获取图片，图片路径自己确定
                        setClipboardImage(image);
                        robot.keyPress(KeyEvent.VK_CONTROL);// 以下两行按下了ctrl+v，完成粘贴功能
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
                        robot.delay(700);// 延迟一秒再发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
                        robot.keyPress(KeyEvent.VK_ENTER);// 回车
                    }
                }
                String cmd2 = "tskill iexplore";// 通过cmd关闭浏览器进程
        }, 1000, 30000);// 1000表示延迟一秒执行，300000表示300每十分钟循环发送一次
    }

    public static void setClipboardImage(final Image image) {
        Transferable trans = new Transferable() {
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[] { DataFlavor.imageFlavor };
            }
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return DataFlavor.imageFlavor.equals(flavor);
            }
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                if (isDataFlavorSupported(flavor))
                    return image;
                throw new UnsupportedFlavorException(flavor);
            }
        };
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
    }
}


/**QQ
 * 第一个："http://wpa.qq.com/msgrd?v=3&uin=321307426&site=qq&menu=yes"自己替换中间的QQ号就OK
 *第二个"tencent://message/?uin=321307426Site=http://vps.shuidazhe.com&Menu=yes&card_type=group"也是替换中间的QQ号就OK
 *第三个"mqqwpa://im/chat?chat_type=wpa&uin=321307426&version=1&src_type=web&web_src=oicqzone.com"这个好像是手机端调用QQ聊天窗口的url，未验证，PC端不可用
 *调用QQ群聊天窗口
 *第一个"http://shang.qq.com/wpa/qunwpa?idkey=a5ec3a8ec44f935d6bcac5a4364be67be5265f5ff46ed129f54340987ef41819"QQ群，idkey是QQ群推广地址，查询链接（需要是群管理员）https://qun.qq.com/join.html
 *第二个"https://jq.qq.com/?_wv=1027&k=5WYnAtL"就是QQ群分享链接，手机QQ群资料下面分享群链接就是
 *第三个"mqqapi://card/show_pslcard?src_type=internal&version=1&uin=811430241&card_type=group&source=qrcode"不可用，先留存吧
 *
 *
 *
 *
 */

