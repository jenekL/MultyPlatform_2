package com.company;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRW {

    static public void readInfo(String direction, ArrayList<Furniture> furnitureArrayList) {
        Scanner sc = null;
        String[] furnitureData = null;
        try {
            sc = new Scanner(new File(direction));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert sc != null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            furnitureData = line.split(";");

            try {
                Checker.checkString(furnitureData[0]);
                Checker.checkString(furnitureData[1]);
                Checker.checkString(furnitureData[4]);

                if (furnitureData[0].equals("Bed")) {
                    furnitureArrayList.add(new Bed(Integer.parseInt(furnitureData[2]), furnitureData[1],
                            Integer.parseInt(furnitureData[3]), furnitureData[4]));
                } else if (furnitureData[0].equals("Sofa")) {
                    furnitureArrayList.add(new Sofa(Integer.parseInt(furnitureData[2]), furnitureData[1],
                            Integer.parseInt(furnitureData[3]), furnitureData[4]));
                }

            }   catch (NumberFormatException e){
                Logger.addLog(e.getMessage());
                e.printStackTrace();
            }
            catch (Exception e) {
                Logger.addLog(e.getMessage());
                e.printStackTrace();
            }

//System.out.println(furnitureData[0] + furnitureData[1] + furnitureData[2] + furnitureData[3] + furnitureData[4]);
        }
    }

        static public void serializationToFile(String directory, ArrayList<Furniture> furnitureArrayList) throws IOException {

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(Furniture f: furnitureArrayList) {
                oos.writeObject(f.getAll());
            }
            oos.flush();
            os.flush();
            oos.close();
            os.close();

            byte[] bArray = os.toByteArray();

            FileOutputStream outFile = new FileOutputStream(directory);

             Logger.addLog("Файл " + directory + " открыт для записи");

            outFile.write(bArray);

            Logger.addLog("Записано: " + bArray.length + " байт");

            outFile.close();


        }

        static public void deserializationFromFile(String direction, int numOfElements) {

            byte[] bytesReaded = null;
            FileInputStream inFile = null;
            int bytesAvailable = 0;
            try {
                inFile = new FileInputStream(direction);
                bytesAvailable = inFile.available();
                bytesReaded = new byte[bytesAvailable];

                Logger.addLog("Файл " + direction + " открыт для чтения");
                Logger.addLog("Готово к считыванию: " + bytesAvailable + " байт");

                int count = inFile.read(bytesReaded, 0, bytesAvailable);
                Logger.addLog("Считано: " + count + " байт");
                for (int i = 0; i < count; i++) {
                    System.out.print(bytesReaded[i]);
                }
                System.out.println();
                inFile.close();

                ByteArrayInputStream is = new ByteArrayInputStream(bytesReaded);
                ObjectInputStream ois = new ObjectInputStream(is);

                for (int i = 0; i < numOfElements; i++) {
                    String a = (String) ois.readObject();
                    System.out.println(a);
                }

            } catch (IOException | ClassNotFoundException e) {
                Logger.addLog(e.getMessage());
                e.printStackTrace();
            }
        }



        public void surDis(String direction, ArrayList<Furniture> furnitureArrayList) throws IOException {
            ByteArrayOutputStream os =
                    new ByteArrayOutputStream();

            ObjectOutputStream oos =
                    new ObjectOutputStream(os);
            for(Furniture f: furnitureArrayList) {
                System.out.println(f.getAll());
                oos.writeObject(f.getAll());
            }

            byte[] bArray = os.toByteArray();

            oos.flush();
            os.flush();
            oos.close();
            os.close();

            for(byte b: bArray) {
                System.out.print(b);
            }
            System.out.println();

            ByteArrayInputStream is = new ByteArrayInputStream(bArray);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

for(Furniture f: furnitureArrayList) {
    String a = (String) ois.readObject();
    System.out.println(a);
}

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

}