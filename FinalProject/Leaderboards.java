import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Leaderboards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaderboards extends World
{
    private int WIDTH = 1280;
    private int HEIGHT = 720;
    private Map<String, Integer> scores = loadFile("scores.txt");
    private List<String> top10 = new ArrayList<String>();

    public Leaderboards()
    {    
        super(1280, 720, 1, false);
        setPaintOrder(Slider.class, Text.class, Button.class);
        addObject(new Slider(WIDTH/2, HEIGHT, (WIDTH/4) * -1, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionLeft.png"), "Nothing", 0), WIDTH/4, HEIGHT/2);
        addObject(new Slider(WIDTH/2, HEIGHT, WIDTH*5/4, HEIGHT/2, 1.0, 1.1, new GreenfootImage("TransitionRight.png"), "Nothing", 0), WIDTH*3/4, HEIGHT/2);
        addObject(new Button("Exit", getHeight()/20, 700.0/300.0, "TitleScreen"), getWidth()/2, getHeight()*47/50);
        for(Map.Entry<String, Integer> entry : scores.entrySet()){
            top10.add(entry.getKey());
        }
        bubbleSort(top10, top10.size());
        //for(String str : top10){
        //    System.out.println(str);
        //}
        //showText(top10.get(top10.size()-1), 100, 100);
        addLabel(top10.size()-1, 330, 290);
        addLabel(top10.size()-2, 330, 400);
        addLabel(top10.size()-3, 330, 505);
        addLabel(top10.size()-4, 330, 610);
        
        addLabel(top10.size()-5, 885, 200);
        addLabel(top10.size()-6, 885, 310);
        addLabel(top10.size()-7, 885, 415);
        addLabel(top10.size()-8, 885, 520);
        addLabel(top10.size()-9, 885, 628);
    }
    
    public void addLabel(int name, int x, int y){
        if(name < 0){
            return;
        }
        addObject(new Text(top10.get(name)), x, y);
        addObject(new Text(scores.get(top10.get(name))+""), x + 210, y);
    }
    
    public java.util.Map<String, Integer> loadFile(String filename) {
        Map<String, Integer> fileText = new HashMap<String, Integer>();
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(filename));
            String input;
            while ((input = file.readLine()) != null) {
                String name = input.split(" ")[0];
                int score = Integer.parseInt(input.split(" ")[1]);
                if(fileText.containsKey(name)){
                    if(score > fileText.get(name)){
                        fileText.put(name, score);
                    }
                }else{
                    fileText.put(name, score);
                }
            }
        }
        catch (FileNotFoundException fnfe) {
            //fnfe.printStackTrace();
            return null;
        }
        catch (IOException ioe) {
            //ioe.printStackTrace();
            return null;
        }
        finally {
            try {
                file.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (NullPointerException npe) {
                //npe.printStackTrace();
            }
        }
        return fileText;
    }
    
    private void bubbleSort(List<String> arr, int n)
    {
        if (n == 1) return;
        for (int i=0; i<n-1; i++){
            if (scores.get(arr.get(i)) > scores.get(arr.get(i+1)))
            {
                String temp = arr.get(i);
                arr.set(i, arr.get(i+1));
                arr.set(i+1, temp);
            }
        }
        bubbleSort(arr, n-1);
    }
    
}
