package com.yabushan.test.util.imageUtils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class T {


	public static void main(String[] args) throws Exception {
		/*JpegTool j = new JpegTool();
		try {
			j.SetScale(1);
			j.SetSmallHeight(1000);
			j.doFinal("E:\\sxf.jpg","E:\\1-1000.jpg");
		} catch (JpegToolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		//根据ComminsMutilpartFile得到文件输入流，BufferedImage读取这个输入流得到bufferedImage实例
     
		 File file=new File("D:\\ss.jpg");
		 BufferedImage bufferedImage=
			        ImageIO.read(file);
        BufferedImage bufferedImage1=new BufferedImage(	bufferedImage.getWidth()*80/bufferedImage.getHeight(),80, BufferedImage.TYPE_INT_BGR);
       
        System.out.println(file.getName());
         String name="D://sss.jpg";
         name=name.substring(name.lastIndexOf("."));
         System.out.println(name);

       Image image=
           bufferedImage.getScaledInstance(	bufferedImage.getWidth()*80/bufferedImage.getHeight(), 80, BufferedImage.SCALE_AREA_AVERAGING);//钓鱼getScaledInstance得到一个一个60*60的Image对象
       System.out.println("buffereadimage:width---h"+bufferedImage.getWidth()+"////"+bufferedImage.getHeight());
       System.out.println("bufferreadimage1:width---1"+bufferedImage1.getWidth()+"///"+bufferedImage1.getHeight());
       bufferedImage1.getGraphics().drawImage(image, 0, 0, null);
       ImageIO.write(bufferedImage1, "png",new File("D:\\80sb.jpg"));//把图片输出
        System.out.println(bufferedImage.getWidth()/2);
	}

}
