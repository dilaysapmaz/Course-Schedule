/* Author: Dilay SAPMAZ
 * ID: 041701032
 * Finish Date: 26.03.2018
 * Explanation: This code reads txt file and makes schedule for each student.
 */
package assignment4;
import javafx.scene.paint.Color;
public class Course {
	
	private String courseCode;
	private Color color;
	
	Course(){
		
	}
	Course(String name){
		courseCode = name;
		
		if(courseCode.substring(0,4).equals("COMP"))
			color = color.PURPLE;
		else if(courseCode.substring(0,2).equals("EE"))
			color=color.GREEN;
		else
			color = color.ORANGE;	
	}
	public void setCourseCode(String name) {
		courseCode = name;
	}
	public void setColor(Color color) {
		this.color=color;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public Color getColor() {
		return color;
	}

}
