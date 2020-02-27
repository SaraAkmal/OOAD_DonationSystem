/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveData implements Serializable {

    ArrayList<Object> ObjectsToSave;
    String FileName;

    int isEmpty;

    public SaveData(ArrayList Objects, String FileName) {
        this.ObjectsToSave = Objects;
        this.FileName = FileName;


    }


    public void SerializeData(ArrayList ObjectsToSave) {

        //Serialize in another file !!

        try {
            FileOutputStream file = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println(ObjectsToSave.isEmpty());
            out.writeObject(ObjectsToSave);
            if(out != null){ out.flush();
                out.close();
                file.close();
            }

            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

int getisEmpty() {
    FileInputStream file = null;
    try {
        file = new FileInputStream(FileName);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    try {
        if(file.getChannel().size() == 0){
            isEmpty = -1;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return isEmpty;
}

    public ArrayList DeserializeData() throws FileNotFoundException {
        // Deserialization

        // Reading the object from a file
        ArrayList<Object> ListToReturn = new ArrayList<>();
        FileInputStream file = new FileInputStream(FileName);


        try {
            if (file.getChannel().size() == 0){

            }
            else{


                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(file);
                    ListToReturn = (ArrayList<Object>)in.readObject();

                   // System.out.println(ListToReturn.isEmpty());
                    in.close();
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                System.out.println(ListToReturn.isEmpty());




            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ListToReturn;
    }
}














