import java.io.*;
import java.util.*;
public class File_Handling {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fis = new FileInputStream("C:\\Users\\Tanya Maheshwari\\eclipse-workspace\\input.txt");
				FileOutputStream fos= new FileOutputStream("C:\\Users\\Tanya Maheshwari\\eclipse-workspace\\output.txt")){
			int bytedata;
			while((bytedata=fis.read())!=-1) {
				fos.write(bytedata);
			}
			System.out.println("File Copied Successfully");
		}
		
		catch (FileNotFoundException e) {
            System.out.println(" Source file not found: " + "C:\\Users\\Tanya Maheshwari\\eclipse-workspace\\input.txt");
		}
		catch(IOException e) {
			e.printStackTrace();
		}	

	}

}
