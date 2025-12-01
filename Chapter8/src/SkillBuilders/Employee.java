package SkillBuilders;

public abstract class Employee 
{
	private String firstName, lastName;
	
	//Constructor method
	public Employee(String f, String l)
	{
		firstName = f;
		lastName = l;
	}
	
	public String toString()
	{
		return(firstName + " " + lastName);
	}
	
	abstract double pay(double period);
	
}
