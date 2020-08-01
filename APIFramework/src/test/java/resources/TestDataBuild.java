package resources;

import pojo.AddEmployeeSerialize;

public class TestDataBuild {
	public AddEmployeeSerialize addempload(String name, String salary) {
		AddEmployeeSerialize a = new AddEmployeeSerialize();
		a.setName(name);
		a.setSalary(salary);
		a.setAge(76);
		return a;
	}
}
