package com.testbots;

import java.io.*;

public class RunPythonCodeFromJava {
    public static void main(String args[]) {
        RunPythonCodeFromJava obj = new RunPythonCodeFromJava();
        try {
            obj.runPy();
            obj.checkIfOutputIsGenerated();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void runPy() throws InterruptedException {

        try {


            String scriptPath = "E:\\infinity\\gitrepo\\testbots\\webScanner\\src\\main\\resources\\pyrunner.bat";

            Runtime.getRuntime().exec(scriptPath);


            //String path = Utils.getProperty("pathToShellScript");
            String[] command = {scriptPath};
            ProcessBuilder p = new ProcessBuilder(command);
            System.out.println(command.toString());
            try {

                Process p2 = p.start();
                OutputStream out = p2.getOutputStream();
                out.write("command\n".getBytes());
                out.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("Script output is: " + line);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean checkIfOutputIsGenerated() {
        boolean isReturned = false;
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("E:\\infinity\\gitrepo\\testbots\\decisionTree\\src\\TestDataOutput.csv"));
            String lastLine = "";
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                lastLine = sCurrentLine;
                if (lastLine.equals("Done")) {
                    isReturned = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("return value is: " + isReturned);
        return isReturned;
    }
}
