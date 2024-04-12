import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import javax.imageio.ImageIO;


public class ImageHandling{
    //customize image size
    public static int width = 800;
    public static int height = 800;
    public static void main (String[] args) throws IOException{
        BufferedImage image = null;
        image = readFromFile(width, height, image);
        writeToFile(image);
    }

    private static BufferedImage readFromFile(int width, int height, BufferedImage image) throws IOException{
        //can customize the name of the image file that we are converting
        File imageFile = new File("./test_image.png");
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(imageFile);
        return image;
    }

    private static void writeToFile(BufferedImage image) throws IOException{
        try{
            File output = new File("./ASCII_out.txt");
            output.createNewFile();
            FileWriter myWriter = new FileWriter("ASCII_out.txt");
            for(int i = 0; i < width; i++){        
                String input= "";
                for(int j = 0; j < height; j++){
                    int color = image.getRGB(j,i);
                    int blue = color & 0xff;
                    int green = (color & 0xff00) >> 8;
                    int red = (color & 0xff0000) >> 16;
                    int color_sum = blue + green + red;

                    //assign ASCII character to pixel
                    System.out.print(input);
                    if (color_sum == 0){
                        input += "#";
                    }
                    else if(color_sum > 0 && color_sum < 100){
                        input += "X";
                    }
                    else if(color_sum >= 100 && color_sum < 200){
                        input += "%";
                    }
                    else if(color_sum >= 200 && color_sum < 300){
                        input += "&";
                    }
                    else if(color_sum >= 300 && color_sum < 400){
                        input += "*";
                    }
                    else if(color_sum >= 400 && color_sum < 500){
                        input += "+";
                    }
                    else if(color_sum >= 500 && color_sum < 600){
                        input += "/";
                    }
                    else if(color_sum >= 600 && color_sum < 700){
                        input += "(";
                    }
                    else if(color_sum >= 700 && color_sum < 755){
                        input += "'";
                    }
                    else{
                        input += " ";
                    }
                }
                input += "\n";
                myWriter.write(input);
            }
            myWriter.close();
            System.out.println("writing complete");
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}