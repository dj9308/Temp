package exam2;

public class Student {
private String name;
private Homework myHomework;

public Homework getMyHomework() {
	return myHomework;
}

public void setMyHomework(Homework myHomework) {
	this.myHomework = myHomework;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public Student() {
	super();
}
}
