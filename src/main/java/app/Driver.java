package app;


import app.dao.DaoUtility;
import app.dao.EmployeeDAO;
import app.dao.EmployeeDaoImpl;
import app.dto.Employee;

public class Driver {
	public static void main(String[] args) {

		// EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(); // tight coupling

		// CRUD
		// Create dao using MySql
		 EmployeeDAO employeeDao = new EmployeeDaoImpl(DaoUtility.getConnectionToMySQL()); // loose coupling

		// Create dao using Oracle
//		 EmployeeDAO employeeDao = new EmployeeDaoImpl(DaoUtility.getConnectionToOracle()); // loose coupling

		// employeeDao.addEmployee(new Employee(1, "name1", 25000.0));
		// employeeDao.addEmployee(new Employee(2, "name2", 35000.0));

		// Read
		Employee foundEmployee = employeeDao.getEmployeeById(1);
		if (foundEmployee != null)
			System.out.println(foundEmployee);
		else
			System.out.println("Employee could not be found for given id");
		Employee foundEmployee2 = employeeDao.getEmployeeById(2);
		if (foundEmployee2 != null)
			System.out.println(foundEmployee2);
		else
			System.out.println("Employee could not be found for given id");

		// delete
		// employeeDao.deleteEmployeeById(1);
		// employeeDao.deleteEmployeeById(2);
		// update employee
		// employeeDao.addEmployee(new Employee(3, "name3", 35000.0));
		Employee updateEmployee = new Employee(3, "Ford", 55000.0);
		employeeDao.updateEmployee(updateEmployee);
		Employee foundEmployee3 = employeeDao.getEmployeeById(3);
		if (foundEmployee3 != null)
			System.out.println(foundEmployee3);
		else
			System.out.println("Employee could not be found for given id");

	}

}
