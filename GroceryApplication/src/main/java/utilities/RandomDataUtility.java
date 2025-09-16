package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker=new Faker();
	
public String radomUsername()
{
	return faker.name().username();
}
public String radomPassword()
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
