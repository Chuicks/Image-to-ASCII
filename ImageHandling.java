import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageHandling{
    public static void main (String[] args) throws IOException{
        //customize image size
        int width = 800;
        int height = 800;
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
            ImageIO.write(image, "txt",output);
            System.out.println("writing complete");
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}