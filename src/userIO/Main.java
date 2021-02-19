package userIO;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Выберите режим. 1 - чтение; 2 - запись");

        Scanner scanMode = new Scanner(System.in);
        int mode = scanMode.nextInt();

        if (mode == 1) {

            BufferedReader fileReader = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader reader = null;

            try {

                System.out.println("Введите имя файла, который нужно считать");

                reader = new BufferedReader(new FileReader("D:\\" + fileReader + ".txt"));

                String line = reader.readLine();
                System.out.println(line);

            } catch (FileNotFoundException e) {

                System.out.println("File not found");

            } catch (IOException ioException) {

                ioException.printStackTrace();

            } finally {

                if (reader != null) {
                    reader.close();

                }
            }

        } else if (mode == 2) {

            BufferedReader fileWriter = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите имя файла, в который нужно что-то записать");

            try(Writer writer = new FileWriter("D:\\" + fileWriter + ".txt")) {

                BufferedReader write = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Введите, что нужно заисать в файл");

                writer.write(String.valueOf(write));

                writer.flush();

            }

            catch(IOException ex){

                System.out.println(ex.getMessage());

            }

        }else {

            System.out.println("Некорректный режим");

        }
    }
}
