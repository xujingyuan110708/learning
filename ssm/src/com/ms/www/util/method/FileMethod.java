package com.ms.www.util.method;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 有关文件处理方法类
 * @author zxj
 *
 */
public class FileMethod {
	/**
	 * 判断文件是否存在
	 * @param path
	 * @return
	 */
	public static boolean checkExist(String path){
		File file = new File(path);       
		if(file.exists()){       
			return true;    
		}else{       
			return false;       
		}       
	}
	
	/**
	 * 文件重新命名
	 * @param fileName   文件名称
	 * @return
	 */
	public static String generateFileName(String fileName){
        String formatDate = new SimpleDateFormat("yyMMddHHmmss")
                .format(new Date());
        int random = new Random().nextInt(10000);
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);
        return formatDate + random + extension;
    }
	
	/**
	 * 转换文件大小格式
	 * @param size        文件大小
	 * @return
	 */
	public static String getFileSize(String size){
		String str = "0";
		DecimalFormat df  = new DecimalFormat("###.0"); 
		if(null!=size && size.length()>0){
			int s1 = Integer.parseInt(size);
			if(s1/1024<1024){//如果小于1M
				str = df.format(((double)s1/(double)1024))+"KB";
			}else if(s1/1024>=1024){//如果大于1M
				str = df.format((s1/(1024*1024)))+"MB";
			}else if(s1/1024>=1024*1024){//如果大于1024MB
				str = df.format((s1/(1024*1024*1024)))+"GB";
			}
		}
		return str;
	}
	
	/**
	 *  重新绘制图片
	 * 1、将图片缩放到指定大小
	 * 2、按指定尺寸裁剪图片
	 * @param picName 图片名称
	 * @param path 存储路径
	 * @param srcFile 源图片文件
	 * @param zoomWidth 缩放宽度
	 * @param zoomHeight 缩放高度
	 * @param x 裁剪起始横坐标
	 * @param y 裁剪起始纵坐标
	 * @param width 裁剪宽度
	 * @param height 裁剪高度
	 * @return 图片名称
	 */
	public static String drawPicture(String picName,String path, File srcFile,int zoomWidth, int zoomHeight,int x,int y,int width,int height) throws Exception {
		//文件重命名
		String pictureName = FileMethod.generateFileName(picName);
		//读取源文件，将文件转换成图片文件
		Image baseImage = ImageIO.read(srcFile);
		//缩放图片，将图片缩放到指定大小
		baseImage = baseImage.getScaledInstance(zoomWidth, zoomHeight,Image.SCALE_FAST);
		//得到裁剪后的图片
		Image croppedImage = FileMethod.cropImage(baseImage,x, y, width, height);
		//生成图片
		BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(croppedImage, 0, 0, width, height, null);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+File.separator+pictureName));
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(bufferedImage);
		bos.close();
		return pictureName;
	}
	
	/**
	 * 裁剪图片
	 * @param baseImage 图片文件
	 * @param x 裁剪的起始横坐标
	 * @param y 裁剪起始纵坐标
	 * @param width 裁剪宽度
	 * @param height 裁剪高度
	 * @return 裁剪后的图片
	 */
	public static Image cropImage(Image baseImage, int x,int y,int width,int height){
		ImageFilter filter = new CropImageFilter(x, y, width, height);
		ImageProducer producter = new FilteredImageSource(baseImage.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(producter);
	}
	
	/**  
     * 图像缩放 jpg格式  
     * 按指定大小缩放
     * @param imgsrc        原图片文件路径  
     * @param imgdist       生成的缩略图片文件路径  
     * @param widthdist     生成图片的宽度  
     * @param heightdist    生成图片的高度  
     */  
    public static void reduceImg(String imgsrc, String imgdist, int widthdist,int heightdist) {   
        try {   
            File srcfile = new File(imgsrc);   
            if (!srcfile.exists()) {   
                return;   
            }   
            Image src = ImageIO.read(srcfile);   
  
            BufferedImage tag = new BufferedImage((int)widthdist,(int)heightdist, BufferedImage.TYPE_INT_RGB);   
            /*  
             * Image.SCALE_SMOOTH 的缩略算法  生成缩略图片的平滑度的  
             * 优先级比速度高 生成的图片质量比较好 但速度慢  
             */  
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist,heightdist,Image.SCALE_SMOOTH), 0, 0, null);   
               
            FileOutputStream out = new FileOutputStream(imgdist);   
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);   
            encoder.encode(tag);   
            out.close();   
  
        } catch (IOException ex) {   
            ex.printStackTrace();   
        }   
    }
}
