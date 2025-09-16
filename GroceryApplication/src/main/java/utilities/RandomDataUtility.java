package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker=new Faker();
	
public String randomUsername()
{
	return faker.name().username();
}
public String randomPassword()
{
	return faker.internet().password();
}
public String radomEmail()
{
	return faker.internet().emailAddress();
}
public String radomFirstName()
{
	return faker.name().firstName();
}
}
