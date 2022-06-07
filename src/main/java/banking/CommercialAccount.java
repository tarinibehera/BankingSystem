package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Account implementation for commercial (business) customers.<br><br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
	private List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		// complete the function
		super(company, accountNumber, pin, startingDeposit);
		authorizedUsers = new ArrayList<>();
		addAuthorizedUser(new Person(company.getCompanyName(), null, company.getIdNumber()));
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		// complete the function
		List<Person> persons = authorizedUsers.stream().filter(p -> p.getIdNumber() == person.getIdNumber()).collect(Collectors.toList());
		if(persons.size() == 0)
			authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		List<Person> persons = authorizedUsers.stream().filter(p -> p.getIdNumber() == person.getIdNumber()).collect(Collectors.toList());
        return (persons.size() > 0);
	}
}
