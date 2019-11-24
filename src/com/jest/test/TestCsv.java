package com.jest.test;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;

public class TestCsv {
    public static void main(String[] args) {
        String path = "resultat.csv";
        int array[][] = new int[2][5];
        int newArray[][] = new int[array.length+10][5];
        System.arraycopy(array,0,newArray,0,newArray.length);



        try {
            CsvReader reader = new CsvReader(path);
            while (reader.readRecord())
            {
                String record = reader.getRawRecord();
                String [] recSpt = record.split(",");
                int [] recint = new int[10];
                for (int i=0;i<10;i++)
                {
                    recint[i] = Integer.parseInt(recSpt[i]);
                }
                for (int i=0;i<10;i++)
                {
                    System.out.print(recint[i]+" ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
