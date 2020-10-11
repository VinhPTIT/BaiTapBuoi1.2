package topRate;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChangeImageColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File originalImage = new File("D:\\2020\\TopRate\\anhmoi.BMP");
		BufferedImage img = null;
		try {
			// đọc file ảnh
			img= ImageIO.read(originalImage);
//			BufferedImage GrayscaleImage = new BufferedImage(
//					img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
//			
			// Chuyển đổi ảnh sang màu xanh
			for(int i=0;i<img.getWidth();i++){
	            for(int j=0;j<img.getHeight();j++){
	                Color c = new Color(img.getRGB(i, j));
	                
	                int red = c.getRed() + 1;
	    		    int green = c.getGreen() + 1;
	    		    int blue = c.getBlue() + 1;
	    		    
	    		    System.out.print(red + "." + green + "." + blue + " ");
	    		    
	    		    if(red > blue && red>green ) {
	    		    double index = (double)(256-red)/80 + 1.8;
	    		    	if (red/green>=index || red/blue>=index) {
	    		    		int temp = red ;
	    		    		red = blue;
	    		    		blue = temp;
	    		    	}
	    		    }
	    		    
	    			int p = (red << 16) | (green << 8) | blue;
	    			img.setRGB(i, j, p);
	             
	            }
	            System.out.println();
	        }
			// ghi file ảnh
			ImageIO.write(img,"BMP",new File("D:\\2020\\TopRate\\convert.BMP"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
