package com.study;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {
    private static final Random r = new Random();
    private static final int width = 148;
    private static final int height = 26;

    private static final char[] c = {'a','b','c','d','e','f',
    'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
    'v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};

    public static final BufferedImage createImage(HttpSession session, int length){
//        根据宽高创建一张缓冲区图像，使用正整数的RGB格式
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//        从图像中获得画笔
        Graphics g = bi.getGraphics();
//        设置画笔颜色
        g.setColor(new Color(175, 215, 151));
//        用画笔填充矩形背景色
        setBackGround(g);
        drowRandomLine((Graphics2D) g);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            int index = r.nextInt(c.length);
            sb.append(c[index]);
//            设置字体
            g.setFont(new Font("微软雅黑", Font.PLAIN, r.nextInt(5) + 15));
            g.setColor(new Color(r.nextInt(200), r.nextInt(200),r.nextInt(200)));
            g.drawString(Character.toString(c[index]),(i+1)*20,18);
        }
//        将验证码存入到session中
        session.setAttribute("sb",sb.toString());
        g.dispose();
        return bi;
    }

    private static void setBackGround(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
    }

    private static void drowRandomLine(Graphics2D g){
        g.setStroke(new BasicStroke(0.3f));
        for(int i=0;i<3;i++){
            g.setColor(new Color(r.nextInt(10), r.nextInt(10),r.nextInt(10)));
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
    }
}
