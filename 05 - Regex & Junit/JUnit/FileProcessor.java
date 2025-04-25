import java.io.*;
class FileProcessor {
   public void writeToFile(String filename, String content) throws IOException {
       BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
       writer.write(content);
       writer.close();
   }
   public String readFromFile(String filename) throws IOException {
       BufferedReader reader = new BufferedReader(new FileReader(filename));
       StringBuilder sb = new StringBuilder();
       String line;
       while ((line = reader.readLine()) != null) {
           sb.append(line);
       }
       reader.close();
       return sb.toString();
   }
}
