/* Author: Dilay SAPMAZ
 * ID: 041701032
 * Finish Date: 26.03.2018
 * Explanation: This code reads txt file and makes schedule for each student.
 */
package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class dilay_sapmaz extends Application {

	public void start(Stage primaryStage) throws FileNotFoundException{

		//Scene parameters
		int sceneWidth = 900; 
		int sceneHeight = 650;
		Pane pane = new Pane();
		//create file object
		File file = new File("schedule2.txt"); 
		//if file is not found, report and exit program
		if(!file.exists()) {    
			System.out.println("File can not be found! exiting program...");
			System.exit(1);
		}


		Scanner input = new Scanner(file);   // open a scanner object to read from file

		//first takes students name and writes it to the pane
		String a = input.nextLine();
		Text myText = new Text();
		myText.setX(10);
		myText.setY(12);
		myText.setText(a);
		pane.getChildren().add(myText);


		Course[][] schedule = new Course[5][8];
		String days[] = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};

		while(input.hasNext()) { 

			String str = input.nextLine();
			String[] parts = str.split(":");

			for(int i=0;i<days.length;i++) {
				if(parts[1].equals(days[i])) {
					for(int j=2;j<parts.length;j++) {
						schedule[i][Integer.parseInt(parts[j])-1]=new Course(parts[0]);

					} 
				}
			}


			String numbers[] = {"1","2","3","4","5","6","7","8"}; //days array
			for(int i=0;i<days.length;i++) {
				for(int j=0;j<numbers.length;j++) {
					Text text=new Text(); //for course's names

					//for days
					Text textDays = new Text();
					textDays.setX(70);
					textDays.setY(190+70*i);
					textDays.setText(days[i]);
					pane.getChildren().add(textDays);
					//rectangles
					Rectangle rectangle = new Rectangle();
					rectangle.setX(150+70*j);
					rectangle.setY(150+70*i);
					rectangle.setHeight(70);
					rectangle.setWidth(70);
					rectangle.setStroke(Color.BLACK);
					//if schedule is not null, it sets colors, coursenames
					if(schedule[i][j]!=null) {
						rectangle.setFill(schedule[i][j].getColor());
						text.setText(schedule[i][j].getCourseCode());
						text.setX(rectangle.getX()+5);
						text.setY(rectangle.getY()+15);
					}else {
						rectangle.setFill(Color.BLUE);
					}
					
					pane.getChildren().add(rectangle);
					pane.getChildren().add(text);
				}
			}
			for(int i=0;i<numbers.length;i++) {
				//for hours(numbers: 1 2 3 4..)
				Text textNumbers = new Text();
				textNumbers.setX(170+70*i);
				textNumbers.setY(130);
				textNumbers.setText(numbers[i]);
				pane.getChildren().add(textNumbers);
			}


		}

		//needed parameters for new pane
		Scene scene = new Scene(pane, sceneWidth, sceneHeight);
		primaryStage.setTitle(a + "s Schedule"); 
		primaryStage.setScene(scene); 
		primaryStage.setResizable(false);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}


}

